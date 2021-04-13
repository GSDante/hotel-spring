package com.ufrn.imd.hotelspringlocacao.controller;

import java.io.StringReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ufrn.imd.hotelspringlocacao.model.MessageQuarto;
import com.ufrn.imd.hotelspringlocacao.model.MessageQuartoNota;
import com.ufrn.imd.hotelspringlocacao.model.Quarto;
import com.ufrn.imd.hotelspringlocacao.repository.QuartoRepository;

@RestController
@RequestMapping("/Quartos")
public class QuartoController {

	@Autowired
	QuartoRepository quartoRepository;
	
	@GetMapping()
	public String getQuartos() {
		List<Quarto> quartos = quartoRepository.findByIsOcupado(false);
		
		String response = "Digite o numero do quarto desejado: \n";
		for(Quarto quarto : quartos) {
			response +=" Quarto " 
					+ quarto.getNumero() + " : Valor R$ " + String.valueOf(quarto.getValor())
					+ "; Nota " + String.valueOf(quarto.getNota()) + "\n";
		}
		
		return response;
	}
	
	@PostMapping("/Alugar")
	public String alugaQuarto(@RequestBody String message) {
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(message));
		reader.setLenient(true);
		
		MessageQuarto msg = gson.fromJson(reader, MessageQuarto.class);
		if(!quartoRepository.existsByNumero(msg.getNumero())) {
			return "Quarto inexistente";
		}
		
		Quarto quarto = quartoRepository.findByNumero(msg.getNumero()).get();
		quarto.setOcupado(true);
		quarto.setCliente(msg.getUsuario());
		
		quartoRepository.save(quarto);
		
		return "Quarto alugado com sucesso";
	}
	
	@PostMapping("/Avaliar")
	public String avaliaQuarto(@RequestBody String message) {
		
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new StringReader(message));
		reader.setLenient(true);
		
		MessageQuartoNota msg = gson.fromJson(reader, MessageQuartoNota.class);
		
		Quarto quarto = quartoRepository.findByCliente(msg.getNomeUsuario()).get();
		quarto.setOcupado(false);
		quarto.setNota(msg.getNota());
		quarto.setCliente("");
		quartoRepository.save(quarto);
		
		return "Quarto avaliado com sucesso";
	}
	
	@PostMapping("/QuartosDoCliente")
	public String getQuartoDoCliente(@RequestBody String message) {	
		if(!quartoRepository.existsByCliente(message)) {
			return "0";
		}
		
		Quarto quarto = quartoRepository.findByCliente(message).get();
		
		String response = "Quarto a ser avaliado:\n";
		response += "Quarto " + quarto.getNumero() + " nota atual:  " + quarto.getNota();
		return response;
	}
}

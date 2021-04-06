package com.ufrn.imd.hotelspringclienteAuth.controller;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ufrn.imd.hotelspringclienteAuth.model.MessageUsuario;
import com.ufrn.imd.hotelspringclienteAuth.model.Usuario;

import com.ufrn.imd.hotelspringclienteAuth.repository.*;
@RestController
@RequestMapping("/ClienteAuth")
public class ClienteAuthController {
	
		@Autowired
		ClienteAuthRepository clienteRepository;
	/*
	 * @Autowired TokenRepository tokenRepository;
	 */
		
		//private static Integer count = 0;
		
		@PostMapping("/cadastro")
		public String cadastroCliente(@RequestBody String message) 
		{
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(message));
			reader.setLenient(true);
			
			MessageUsuario msg = gson.fromJson(reader, MessageUsuario.class);
			
			if(clienteRepository.existsByLogin(msg.getLogin())) {
				return "-10";
			}
			
			Usuario usuario = new Usuario(msg.getLogin(),msg.getSenha(),1);
			
			
			clienteRepository.save(usuario);
			
			return "10";
		}
		
		@PostMapping("/login")
		public String loginCliente(@RequestBody String message) 
		{
			System.out.println(message);
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(message));
			reader.setLenient(true);
			
			MessageUsuario msg = gson.fromJson(reader, MessageUsuario.class);
			if(!clienteRepository.existsByLogin(msg.getLogin())) {
				return "-1";
			}
			
			Usuario usuario  = clienteRepository.findByLogin(msg.getLogin()).get();
			
			if(usuario.getSenha().equals(msg.getSenha())) 
			{
				return "Bem vindo, " + usuario.getLogin() + " seu token é " 
						+ String.valueOf(usuario.getTokenValue());
			}
			
			return "0";
		}
		
		/*@GetMapping("/Verify/{value}")
		public Integer verify(@PathVariable int value) 
		{
			Optional<Token> tk;
			try 
			{
				tk = tokenRepository.findByValue(value);
				return 1;
			}catch(NotFoundTokenException e) 
			{
				System.out.println("Token inválido");
			}
			
			return 0;
		}*/
	
}

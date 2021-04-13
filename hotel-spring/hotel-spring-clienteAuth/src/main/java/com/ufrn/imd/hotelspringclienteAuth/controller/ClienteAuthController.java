package com.ufrn.imd.hotelspringclienteAuth.controller;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ufrn.imd.hotelspringclienteAuth.model.MessageUsuario;
import com.ufrn.imd.hotelspringclienteAuth.model.Usuario;
import com.ufrn.imd.hotelspringclienteAuth.repository.ClienteAuthRepository;
@RestController
@RequestMapping("/ClienteAuth")
public class ClienteAuthController {
	
		@Autowired
		ClienteAuthRepository clienteRepository;
		
		@Autowired
		private Environment environment;
	
				
		@PostMapping("/cadastro")
		public Usuario cadastroCliente(@RequestBody String message) 
		{
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(message));
			reader.setLenient(true);
			
			MessageUsuario msg = gson.fromJson(reader, MessageUsuario.class);
			
		/*
		 * if(clienteRepository.existsByLogin(msg.getLogin())) { return -1; }
		 */
			
			Usuario usuario = new Usuario(msg.getLogin(),msg.getSenha(),1);
			usuario.setPort(
					Integer.parseInt(environment.getProperty("local.server.port")));
			
			clienteRepository.save(usuario);
			
			return usuario;
		}
		
		@PostMapping("/login")
		public Usuario loginCliente(@RequestBody String message) 
		{
			System.out.println(message);
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(message));
			reader.setLenient(true);
			
			MessageUsuario msg = gson.fromJson(reader, MessageUsuario.class);
		/*
		 * if(!clienteRepository.existsByLogin(msg.getLogin())) { return "-1"; }
		 */
			
			Usuario usuario  = clienteRepository.findByLogin(msg.getLogin()).get();
			
			if(usuario.getSenha().equals(msg.getSenha())) 
			{
			/*
			 * return "Bem vindo, " + usuario.getLogin() + " seu token é " +
			 * String.valueOf(usuario.getTokenValue());
			 */
				return usuario;
			}
			usuario.setPort(
					Integer.parseInt(environment.getProperty("local.server.port")));
			
			//return "0";
			return usuario;
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

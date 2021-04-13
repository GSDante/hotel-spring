package com.ufrn.imd.hotelspringcliente;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@SpringBootApplication
public class HotelSpringClienteApplication {
	
	final static String url_login = "http://localhost:8080/ClienteAuth/login";
	final static String url_cadastro = "http://localhost:8080/ClienteAuth/cadastro";
	final static String url_show = "http://localhost:8081/Quartos";
	final static String url_alugar = "http://localhost:8081/Quartos/Alugar";
	final static String url_showQuartoUsuario = "http://localhost:8081/Quartos/QuartosDoCliente";
	final static String url_avaliar = "http://localhost:8081/Quartos/Avaliar";


	
	public static RestTemplate restTemplate = new RestTemplate();
	public static Gson gson = new Gson();
	public static Scanner scanner = new Scanner(System.in);
	public static int escolha;
	public static String response = null;
	public static String nomeUsuario = null;
	public static String login = null;
	
	public static void login() {
		logger("Login:");
		scanner.nextLine();
		login = scanner.nextLine();
		logger("Senha:");
		String senha = scanner.nextLine();
		MessageUsuario msgUsuario = new MessageUsuario(login,senha);

		String msgUsuarioJson = gson.toJson(msgUsuario);
		response = restTemplate.postForObject(url_login, msgUsuarioJson, String.class);
		logger("Resposta do post login: " + response);
		
	}
	
	public static void showQuartos() {
		response = restTemplate.getForObject(url_show, String.class);
		logger(response);
	}
	
	public static void alugar() {
		scanner.nextLine();
		String numeroQuarto = scanner.nextLine();
		MessageQuarto msg = new MessageQuarto(numeroQuarto,login);
		
		String message = gson.toJson(msg);
		response = restTemplate.postForObject(url_alugar,message, String.class);
		logger(response);
	}
	
	public static void avaliar() {
		response = restTemplate.postForObject(url_showQuartoUsuario,login, String.class);
		
		
		logger(response);
		logger("\nDê uma nota de 0 a 10:\n");
		scanner.nextLine();
		String nota = scanner.nextLine();
		float notaIn = Float.parseFloat(nota);
		
		MessageQuartoNota msg = new MessageQuartoNota(notaIn,login);
		String message = gson.toJson(msg);
		
		response = restTemplate.postForObject(url_avaliar, message, String.class);
		logger(response);
	}
	
	public static void cadastrar() {
		logger("Login:");
		scanner.nextLine();
		String login2 = scanner.nextLine();
		logger("Senha:");
		String senha2 = scanner.nextLine();
		MessageUsuario msgUsuario2 = new MessageUsuario(login2,senha2);

		String msgUsuarioJson2 = gson.toJson(msgUsuario2);
		response = restTemplate.postForObject(url_cadastro, msgUsuarioJson2, String.class);
		logger("Resposta do post cadastro: " + response);	
	}
	
	public static void main(String[] args) {
		
		while(true) {
			logger("1-Entrar\n" + "2-Cadastrar\n");
			escolha = scanner.nextInt();
			while(true) {
				switch(escolha){
				case 1:
					login();					
					
					break;
				case 2:
					cadastrar();
					break;
				}
				if(response.equals("-1")) {
					logger("Login inválido, tente novamente");
					break;
				}else if(response.equals("0")) {
					logger("Senha inválida, tente novamente");
					break;
				}else if(response.equals("-10")) {
					logger("Nome de usuário já existente");
					break;
				}else if(response.equals("10")) {
					logger("Cadastro feito com sucesso");
					break;
				}else {
					
					while(true) {
						logger(" 1-Escolher quarto\n 2-Avaliar quarto\n 3-Sair");
						escolha = scanner.nextInt();
						
						switch(escolha) {
						case 1:
							showQuartos();
							alugar();
							break;
						case 2:
							avaliar();
							break;
						default:
							break;
						}

						if(escolha == 3) {
							break;
						}
					}
				}
			}

			
		}

		
	}
	
	public static void logger(String s) {
		System.out.println(s);
	}

}

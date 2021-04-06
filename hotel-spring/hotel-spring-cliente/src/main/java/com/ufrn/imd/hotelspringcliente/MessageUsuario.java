package com.ufrn.imd.hotelspringcliente;

import java.io.Serializable;

public class MessageUsuario implements Serializable {

	private String login;
	private String senha;
	public MessageUsuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}

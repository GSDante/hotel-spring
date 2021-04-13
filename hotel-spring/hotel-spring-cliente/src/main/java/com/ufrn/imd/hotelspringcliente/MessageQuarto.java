package com.ufrn.imd.hotelspringcliente;

import java.io.Serializable;

public class MessageQuarto implements Serializable{

	private String numero;
	private String usuario;
	
	public MessageQuarto(String numero, String usuario) {
		super();
		this.numero = numero;
		this.usuario = usuario;
	}
	
	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	
	
	
}

package com.ufrn.imd.hotelspringcliente;

import java.io.Serializable;

public class MessageQuartoNota implements Serializable{

	private float nota;
	private String nomeUsuario;
	public MessageQuartoNota( float nota, String nomeUsuario) {
		super();
		this.nota = nota;
		this.setNomeUsuario(nomeUsuario);
	}
	
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
		
		
}

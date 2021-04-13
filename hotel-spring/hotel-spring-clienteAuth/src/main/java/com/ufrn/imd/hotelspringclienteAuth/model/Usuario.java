package com.ufrn.imd.hotelspringclienteAuth.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario{
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name="seq_usuario", initialValue=1, allocationSize=1)
    protected long id;

	private String login;
	private String senha;
	private long tokenValue;
	
	private int port;

	public Usuario() {}
	public Usuario(String login, String senha, long tokenValue) {
		this.login = login;
		this.senha = senha;
		this.setTokenValue(tokenValue);
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(long tokenValue) {
		this.tokenValue = tokenValue;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}

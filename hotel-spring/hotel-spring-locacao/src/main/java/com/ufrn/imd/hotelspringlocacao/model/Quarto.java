package com.ufrn.imd.hotelspringlocacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="quarto")
public class Quarto {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    @SequenceGenerator(name="seq_usuario", initialValue=1, allocationSize=1)
    protected long id;
	
	private String numero;
	private boolean isOcupado;
	private float valor;
	private float nota;
	private String cliente;
	
	public Quarto() {}
	
	public Quarto(long id, String numero, boolean isOcupado, float valor, float nota, String cliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.isOcupado = isOcupado;
		this.valor = valor;
		this.nota = nota;
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isOcupado() {
		return isOcupado;
	}

	public void setOcupado(boolean isOcupado) {
		this.isOcupado = isOcupado;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = (this.nota + nota)/2;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
	
}

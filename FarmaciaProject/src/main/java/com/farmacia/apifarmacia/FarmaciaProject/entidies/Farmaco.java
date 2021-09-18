package com.farmacia.apifarmacia.FarmaciaProject.entidies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Farmaco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Double valor;
	private String nome;
	private String tipo;
	
	public Farmaco() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Farmaco [nome=" + nome + "]";
	}


	public Farmaco(Double valor, String nome, String tipo) {
		super();
		this.valor = valor;
		this.nome = nome;
		this.tipo = tipo;
	}
	
}



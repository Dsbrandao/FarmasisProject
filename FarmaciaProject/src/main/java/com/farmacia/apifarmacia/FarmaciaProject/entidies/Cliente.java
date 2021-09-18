package com.farmacia.apifarmacia.FarmaciaProject.entidies;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String cpf;
	private String nome;
	private String contato;
	
	public Cliente() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
	
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + "]";
	}

	public Cliente(String cpf, String nome, String contato) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
	}


}

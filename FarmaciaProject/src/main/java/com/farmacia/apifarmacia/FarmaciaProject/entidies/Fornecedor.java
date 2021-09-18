package com.farmacia.apifarmacia.FarmaciaProject.entidies;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private String nome;
	private String CNPJ;
	
	public Fornecedor() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	@Override
	public String toString() {
		return "Fornecedor [CNPJ=" + CNPJ + "]";
	}

	public Fornecedor(String nome, String cNPJ) {
		super();
		this.nome = nome;
		CNPJ = cNPJ;
	}

}
package com.farmacia.apifarmacia.FarmaciaProject.entidies;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	
	private String nome;
	private String matricula;
	
	public Funcionario() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + "]";
	}

	public Funcionario(String nome, String matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

}

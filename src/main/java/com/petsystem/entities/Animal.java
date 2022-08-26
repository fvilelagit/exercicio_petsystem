package com.petsystem.entities;

public class Animal {

	
	private Long id;
	private String nome;
	private Integer idade;
	private Double peso;
	
	private Cliente id_cliente;
	
	public Animal() {
		super();
	}

	public Animal(Long id, String nome, Integer idade, Double peso, Cliente id_cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.id_cliente = id_cliente;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Cliente getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Cliente id_cliente) {
		this.id_cliente = id_cliente;
	}

	

	
	
	
	
	
}

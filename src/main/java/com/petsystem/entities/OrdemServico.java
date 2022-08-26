package com.petsystem.entities;

import java.time.Instant;

public class OrdemServico {

	private Long id;
	private Long id_cliente;
	private Double valor;
	private Instant hora_entrada;
	private Instant hora_saida;
	
	
	public OrdemServico() {
		super();
	}
	public OrdemServico(Long id, Long id_cliente, Double valor, Instant hora_entrada, Instant hora_saida) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.valor = valor;
		this.hora_entrada = hora_entrada;
		this.hora_saida = hora_saida;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Instant getHora_entrada() {
		return hora_entrada;
	}
	public void setHora_entrada(Instant hora_entrada) {
		this.hora_entrada = hora_entrada;
	}
	public Instant getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(Instant hora_saida) {
		this.hora_saida = hora_saida;
	}
	
	

	
	
}

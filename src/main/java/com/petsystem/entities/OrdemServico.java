package com.petsystem.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "ordemDeServico")
public class OrdemServico implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double valor;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant hora_entrada;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant hora_saida;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
//	@ManyToMany
//	@JoinTable(name ="ordemDeServicos_animais", 
//	joinColumns = @JoinColumn(name="ordemDeServicos_id"),
//	inverseJoinColumns = @JoinColumn(name="animais_id"))
//	private Set <Animal> animais = new HashSet<>();

	@OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("ordemServico")
	private List<OrdemAnimal> ordemAnimal;
	
	public OrdemServico(Long id, Double valor, Instant hora_entrada, Instant hora_saida, Cliente cliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.hora_entrada = hora_entrada;
		this.hora_saida = hora_saida;
		this.cliente = cliente;

	}

	public OrdemServico() {
		super();
	}

	public OrdemServico(Long id, Cliente cliente, Double valor, Instant hora_entrada, Instant hora_saida) {
		super();
		this.id = id;
		this.cliente = cliente;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

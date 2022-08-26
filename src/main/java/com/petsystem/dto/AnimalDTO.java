package com.petsystem.dto;

import com.petsystem.entities.Cliente;

import lombok.Data;

@Data
public class AnimalDTO{
	
	private Long id;
	private String nome;
	private Integer idade;
	private Double peso;
	
	private Cliente id_cliente;	
	
}

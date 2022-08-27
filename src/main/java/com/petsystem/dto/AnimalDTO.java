package com.petsystem.dto;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.petsystem.entities.Cliente;

import lombok.Data;

@Data
public class AnimalDTO{
	
	private Long id;
	private String nome;
	private Integer idade;
	private Double peso;
	
	private Cliente cliente;	
	
}

package com.petsystem.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petsystem.entities.Cliente;
import com.petsystem.repositorio.ClienteRepositorio;
import com.petsystem.servicos.ClienteServico;

@Service
public class ClienteServicoIMPL implements ClienteServico{

	@Autowired
	ClienteRepositorio repositorio;

	@Override
	public Cliente save(Cliente c) {
		return repositorio.save(c);
	}
	
	
	

}

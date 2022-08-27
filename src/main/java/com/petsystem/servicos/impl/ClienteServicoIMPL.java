package com.petsystem.servicos.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Cliente> findById(Long id) {
		
		return repositorio.findById(id);
	}

	@Override
	public List<Cliente> findAll() {
		return repositorio.findAll();
	}
	
	public void delete(Long id) {

		repositorio.deleteById(id);
		
		
	}
	

}

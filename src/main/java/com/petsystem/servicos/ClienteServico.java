package com.petsystem.servicos;

import java.util.List;
import java.util.Optional;

import com.petsystem.entities.Cliente;

public interface ClienteServico {

	Cliente save(Cliente c);

	Optional<Cliente> findById(Long id);

	List<Cliente> findAll();

	void delete(Long id);

	
}

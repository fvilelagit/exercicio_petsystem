package com.petsystem.servicos;

import java.util.Optional;

import com.petsystem.dto.ClienteDTO;
import com.petsystem.entities.Cliente;

public interface ClienteServico {

	Cliente save(Cliente c);

	Optional<ClienteDTO> findById(Long id);


	
	
}

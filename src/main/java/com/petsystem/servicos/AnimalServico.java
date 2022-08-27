package com.petsystem.servicos;

import java.util.Optional;

import com.petsystem.entities.Animal;

public interface AnimalServico {

	
	Animal save (Animal animal);

	Optional<Animal> findById(Long id);

	void delete(Long id);

	Optional<Animal> findByClienteId(Long id);
	
	
}

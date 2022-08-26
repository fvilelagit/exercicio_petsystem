package com.petsystem.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petsystem.entities.Animal;
import com.petsystem.repositorio.AnimalRepositorio;
import com.petsystem.servicos.AnimalServico;

@Service
public class AnimalServicoIMPL implements AnimalServico{

	@Autowired
	AnimalRepositorio repositorio;

	@Override
	public Animal save(Animal animal) {
		return repositorio.save(animal);
	}

	
}

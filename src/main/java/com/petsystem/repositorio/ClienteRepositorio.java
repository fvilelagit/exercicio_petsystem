package com.petsystem.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petsystem.entities.Cliente;


@Repository
public interface ClienteRepositorio extends JpaRepository <Cliente, Long> {

	
	
}

package com.petsystem.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petsystem.entities.Animal;
@Repository
public interface AnimalRepositorio extends JpaRepository <Animal, Long> {

	Optional<Animal> findByClienteId(Long id);

}

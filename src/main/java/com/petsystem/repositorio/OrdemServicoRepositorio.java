package com.petsystem.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petsystem.entities.Animal;
import com.petsystem.entities.OrdemServico;

@Repository
public interface OrdemServicoRepositorio extends JpaRepository <OrdemServico, Long> {

}

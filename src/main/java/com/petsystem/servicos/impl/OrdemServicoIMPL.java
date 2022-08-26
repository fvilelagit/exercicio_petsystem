package com.petsystem.servicos.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petsystem.entities.OrdemServico;
import com.petsystem.repositorio.OrdemServicoRepositorio;
import com.petsystem.servicos.OrdemServicoServico;

@Service
public class OrdemServicoIMPL implements OrdemServicoServico{

	@Autowired
	OrdemServicoRepositorio repositorio;
	
	
	@Override
	public OrdemServico save(OrdemServico os) {
		return repositorio.save(os);
	}

}

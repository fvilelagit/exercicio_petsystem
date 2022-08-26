package com.petsystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petsystem.dto.ClienteDTO;
import com.petsystem.entities.Cliente;
import com.petsystem.servicos.ClienteServico;


@RestController
@RequestMapping("clientes") 
public class ClienteControllers {

	@Autowired
	private ClienteServico servico;
	
	@PostMapping
	public ResponseEntity <ClienteDTO> criar(@RequestBody ClienteDTO dto){
	
		Cliente c = servico.save(this.conversorDtoParaEntidade(dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		
	}
	
	@GetMapping(value="/id")
	public ResponseEntity<ClienteDTO> findbyId(Long id){
		
		
		List<ClienteDTO> listaDTO = new ArrayList<ClienteDTO>();
		
		Optional<ClienteDTO> cDTO = servico.findById(id);
		
		if (!cDTO.isPresent()) {
			return ResponseEntity.badRequest().body(cDTO.get());
		}

		return  ResponseEntity.ok().body(cDTO.get());
	}
	
	@PutMapping
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO dto){
		
		Optional<ClienteDTO> cliente = servico.findById(dto.getId());
		
		if (!cliente.isPresent()) {
			return ResponseEntity.badRequest().body(dto);
		}
		
		Cliente salvo = servico.save(this.conversorDtoParaEntidade(dto));
		
		return ResponseEntity.ok().body(dto);
		
	}
	
	
	private Cliente conversorDtoParaEntidade(ClienteDTO dto) {
		Cliente c = new Cliente();
		c.setId(dto.getId());
		c.setNome(dto.getNome());
		c.setTelefone(dto.getTelefone());
		return c;
	}
	
	private ClienteDTO conversorEntidadeParaDto(Cliente c) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId(c.getId());
		dto.setNome(c.getNome());
		dto.setTelefone(c.getTelefone());
		
		return dto;
	}
	
	
}

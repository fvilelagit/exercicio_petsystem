package com.petsystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO dto) {

		servico.save(this.conversorDtoParaEntidade(dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);

	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {

		List<Cliente> lista = servico.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<>();

		for (Cliente c : lista) {
			listaDTO.add(this.conversorEntidadeParaDto(c));
		}

		return ResponseEntity.ok().body(listaDTO);

	}

	@GetMapping(value = "/id")
	public ResponseEntity<ClienteDTO> findbyId(Long id) {

		Optional<Cliente> cliente = servico.findById(id);

		if (!cliente.isPresent()) {

			return ResponseEntity.badRequest().body(this.conversorEntidadeParaDto(cliente.get()));
		}

		return ResponseEntity.ok().body(this.conversorEntidadeParaDto(cliente.get()));
	}

	@PutMapping
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO dto) {

		Optional<Cliente> cliente = servico.findById(dto.getId());

		if (!cliente.isPresent()) {

			return ResponseEntity.badRequest().body(this.conversorEntidadeParaDto(cliente.get()));
		}

		servico.save(this.conversorDtoParaEntidade(dto));

		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();

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

package com.petsystem.controllers;

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

import com.petsystem.dto.AnimalDTO;

import com.petsystem.entities.Animal;

import com.petsystem.servicos.AnimalServico;

@RestController
@RequestMapping("animais")
public class AnimalControllers {

	@Autowired
	private AnimalServico servico;

	@PostMapping
	public ResponseEntity<AnimalDTO> create(@RequestBody AnimalDTO dto) {

		servico.save(this.conversorDtoParaEntidade(dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);

	}

	@GetMapping(value = "/id")
	public ResponseEntity<AnimalDTO> findbyId(Long id) {

		Optional<Animal> animal = servico.findById(id);

		if (!animal.isPresent()) {

			return ResponseEntity.badRequest().body(this.conversorEntidadeParaDto(animal.get()));
		}

		return ResponseEntity.ok().body(this.conversorEntidadeParaDto(animal.get()));
	}
	
	@GetMapping(value = "/cliente")
	public ResponseEntity<AnimalDTO> findbyClienteId(Long id) {

		Optional<Animal> animal = servico.findByClienteId(id);

		if (!animal.isPresent()) {

			return ResponseEntity.badRequest().body(this.conversorEntidadeParaDto(animal.get()));
		}

		return ResponseEntity.ok().body(this.conversorEntidadeParaDto(animal.get()));
	}
	
	

	@PutMapping
	public ResponseEntity<AnimalDTO> update(@RequestBody AnimalDTO dto) {

		Optional<Animal> animal = servico.findById(dto.getId());

		if (!animal.isPresent()) {

			return ResponseEntity.badRequest().body(this.conversorEntidadeParaDto(animal.get()));
		}

		servico.save(this.conversorDtoParaEntidade(dto));

		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();

	}

	private Animal conversorDtoParaEntidade(AnimalDTO dto) {
		Animal a = new Animal();
		a.setId(dto.getId());
		a.setNome(dto.getNome());
		a.setIdade(dto.getIdade());
		a.setPeso(dto.getPeso());
		a.setCliente(dto.getCliente());
		return a;
	}

	private AnimalDTO conversorEntidadeParaDto(Animal a) {
		AnimalDTO dto = new AnimalDTO();
		dto.setId(a.getId());
		dto.setNome(a.getNome());
		dto.setIdade(a.getIdade());
		dto.setPeso(a.getPeso());
		dto.setCliente(a.getCliente());

		return dto;
	}

}

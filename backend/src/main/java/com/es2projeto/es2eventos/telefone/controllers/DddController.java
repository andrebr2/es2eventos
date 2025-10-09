package com.es2projeto.es2eventos.telefone.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.telefone.dto.DddDTO;
import com.es2projeto.es2eventos.telefone.entities.DDD;
import com.es2projeto.es2eventos.telefone.services.DddService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ddds")
public class DddController {

	@Autowired
	private DddService dddService;

	// Conversões entre DTO e entidade
	private DDD convertToEntity(DddDTO dto) {
		return new DDD(dto.getCodigoArea());
	}

	private DddDTO convertToDTO(DDD entity) {
		return new DddDTO(entity.getCodigoArea());
	}

	@GetMapping
	public List<DddDTO> getAllDDDs() {
		return dddService.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/{codigoArea}")
	public ResponseEntity<DddDTO> getDDDById(@PathVariable int codigoArea) {
		return dddService.findById(codigoArea).map(this::convertToDTO).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<DddDTO> createDDD(@Valid @RequestBody DddDTO dddDTO) {
		DDD savedDDD = dddService.save(convertToEntity(dddDTO));
		return ResponseEntity.ok(convertToDTO(savedDDD));
	}

	@DeleteMapping("/{codigoArea}")
	public ResponseEntity<Void> deleteDDD(@PathVariable int codigoArea) {
		dddService.delete(codigoArea);
		return ResponseEntity.noContent().build();
	}
}

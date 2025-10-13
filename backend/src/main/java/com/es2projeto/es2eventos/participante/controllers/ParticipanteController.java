package com.es2projeto.es2eventos.participante.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.participante.dto.ParticipanteDTO;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.participante.services.ParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

	private final ParticipanteService service;

	public ParticipanteController(ParticipanteService service) {
		this.service = service;
	}

	@GetMapping
	public List<Participante> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Participante> getById(@PathVariable Long id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Participante create(@RequestBody ParticipanteDTO dto) {
		return service.save(dto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Participante> update(@PathVariable Long id, @RequestBody ParticipanteDTO dto) {
		try {
			Participante atualizado = service.update(id, dto);
			return ResponseEntity.ok(atualizado);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

package com.es2projeto.es2eventos.email.controllers;

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

import com.es2projeto.es2eventos.email.entities.EmailParticipante;
import com.es2projeto.es2eventos.email.services.EmailParticipanteService;

@RestController
@RequestMapping("/emails-participantes")
public class EmailParticipanteController {

	private final EmailParticipanteService service;

	public EmailParticipanteController(EmailParticipanteService service) {
		this.service = service;
	}

	@GetMapping
	public List<EmailParticipante> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmailParticipante> getById(@PathVariable Long id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public EmailParticipante create(@RequestBody EmailParticipante email) {
		return service.save(email);
	}

	@PutMapping("/{id}")
	public EmailParticipante update(@PathVariable Long id, @RequestBody EmailParticipante email) {
		return service.update(id, email);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

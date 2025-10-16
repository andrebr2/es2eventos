package com.es2projeto.es2eventos.inscricao.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.inscricao.DTO.InscricaoDTO;
import com.es2projeto.es2eventos.inscricao.services.InscricaoService;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

	private final InscricaoService inscricaoService;

	public InscricaoController(InscricaoService inscricaoService) {
		this.inscricaoService = inscricaoService;
	}

	@GetMapping
	public ResponseEntity<List<InscricaoDTO>> findAll() {
		return ResponseEntity.ok(inscricaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<InscricaoDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(inscricaoService.findById(id));
	}

	@PostMapping
	public ResponseEntity<InscricaoDTO> create(@RequestBody InscricaoDTO dto) {
		InscricaoDTO created = inscricaoService.save(dto);
		return ResponseEntity.ok(created);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		inscricaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
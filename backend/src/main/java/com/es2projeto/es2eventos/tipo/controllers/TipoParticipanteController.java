package com.es2projeto.es2eventos.tipo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.es2projeto.es2eventos.tipo.dto.TipoParticipanteDTO;
import com.es2projeto.es2eventos.tipo.services.TipoParticipanteService;

@RestController
@RequestMapping("/tipo-participantes")
public class TipoParticipanteController {

	@Autowired
	private TipoParticipanteService service;

	@GetMapping
	public ResponseEntity<List<TipoParticipanteDTO>> findAll() {
		List<TipoParticipanteDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoParticipanteDTO> findById(@PathVariable Long id) {
		TipoParticipanteDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<TipoParticipanteDTO> insert(@RequestBody TipoParticipanteDTO dto) {
		TipoParticipanteDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoParticipanteDTO> update(@PathVariable Long id, @RequestBody TipoParticipanteDTO dto) {
		TipoParticipanteDTO updated = service.update(id, dto);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
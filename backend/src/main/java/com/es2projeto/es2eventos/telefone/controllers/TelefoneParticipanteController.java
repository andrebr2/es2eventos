package com.es2projeto.es2eventos.telefone.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.telefone.dto.TelefoneParticipanteDTO;
import com.es2projeto.es2eventos.telefone.entities.TelefoneParticipante;
import com.es2projeto.es2eventos.telefone.services.TelefoneParticipanteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/telefones-participantes")
public class TelefoneParticipanteController {

	private final TelefoneParticipanteService service;

	public TelefoneParticipanteController(TelefoneParticipanteService service) {
		this.service = service;
	}

	// Conversão DTO ↔ Entidade
	private TelefoneParticipante convertToEntity(TelefoneParticipanteDTO dto) {
	    TelefoneParticipante telefone = new TelefoneParticipante();
	    telefone.setNroTelefone(dto.getNroTelefone());
	    telefone.setCodigoArea(dto.getCodigoArea());
	    // participante será setado no Service pelo participanteId
	    return telefone;
	}


	private TelefoneParticipanteDTO convertToDTO(TelefoneParticipante entity) {
		return new TelefoneParticipanteDTO(entity.getId(), entity.getNroTelefone(), entity.getCodigoArea(),
				entity.getParticipante() != null ? entity.getParticipante().getId() : null);
	}

	@GetMapping
	public List<TelefoneParticipanteDTO> getAll() {
		return service.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TelefoneParticipanteDTO> getById(@PathVariable Long id) {
		return service.findById(id).map(this::convertToDTO).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<TelefoneParticipanteDTO> create(@Valid @RequestBody TelefoneParticipanteDTO dto) {
		TelefoneParticipante telefone = convertToEntity(dto);
		TelefoneParticipante saved = service.save(telefone, dto.getParticipanteId());
		return ResponseEntity.ok(convertToDTO(saved));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TelefoneParticipanteDTO> update(@PathVariable Long id,
			@Valid @RequestBody TelefoneParticipanteDTO dto) {
		try {
			TelefoneParticipante telefone = convertToEntity(dto);
			TelefoneParticipante updated = service.update(id, telefone, dto.getParticipanteId());
			return ResponseEntity.ok(convertToDTO(updated));
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
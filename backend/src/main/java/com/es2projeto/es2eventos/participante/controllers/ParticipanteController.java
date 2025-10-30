package com.es2projeto.es2eventos.participante.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.participante.dto.ParticipanteCadastroDTO;
import com.es2projeto.es2eventos.participante.dto.ParticipanteDTO;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.participante.services.ParticipanteService;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;

	@GetMapping
	public List<ParticipanteDTO> listarTodos() {
		return participanteService.findAll().stream().map(ParticipanteDTO::new)
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ParticipanteDTO buscarPorId(@PathVariable Long id) {
		return participanteService.findById(id).map(ParticipanteDTO::new)
				.orElseThrow(() -> new RuntimeException("Participante não encontrado"));
	}

	@PostMapping
	public ParticipanteDTO cadastrar(@RequestBody ParticipanteCadastroDTO dto) {
		Participante participante = participanteService.registrarParticipante(dto);
		return new ParticipanteDTO(participante);
	}

	@PutMapping("/{id}")
	public ParticipanteDTO atualizar(@PathVariable Long id, @RequestBody ParticipanteDTO dto) {
		Participante participanteAtualizado = participanteService.update(id, dto);
		return new ParticipanteDTO(participanteAtualizado);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		participanteService.delete(id);
	}
}
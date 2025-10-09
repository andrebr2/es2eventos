package com.es2projeto.es2eventos.tipo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es2projeto.es2eventos.tipo.dto.TipoParticipanteDTO;
import com.es2projeto.es2eventos.tipo.entities.TipoParticipante;
import com.es2projeto.es2eventos.tipo.repositories.TipoParticipanteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoParticipanteService {

	@Autowired
	private TipoParticipanteRepository repository;

	// Listar todos
	public List<TipoParticipanteDTO> findAll() {
		List<TipoParticipante> list = repository.findAll();
		return list.stream().map(TipoParticipanteDTO::new).collect(Collectors.toList());
	}

	// Buscar por ID
	public TipoParticipanteDTO findById(Long id) {
		Optional<TipoParticipante> obj = repository.findById(id);
		TipoParticipante entity = obj.orElseThrow(() -> new EntityNotFoundException("TipoParticipante não encontrado"));
		return new TipoParticipanteDTO(entity);
	}

	// Inserir
	public TipoParticipanteDTO insert(TipoParticipanteDTO dto) {
		TipoParticipante entity = new TipoParticipante();
		entity.setDescricao(dto.getDescricao());
		entity = repository.save(entity);
		return new TipoParticipanteDTO(entity);
	}

	// Atualizar
	public TipoParticipanteDTO update(Long id, TipoParticipanteDTO dto) {
		TipoParticipante entity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("TipoParticipante não encontrado"));
		entity.setDescricao(dto.getDescricao());
		entity = repository.save(entity);
		return new TipoParticipanteDTO(entity);
	}

	// Deletar
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new EntityNotFoundException("TipoParticipante não encontrado");
		}
		repository.deleteById(id);
	}
}

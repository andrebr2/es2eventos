package com.es2projeto.es2eventos.telefone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es2projeto.es2eventos.telefone.entities.TelefoneParticipante;
import com.es2projeto.es2eventos.telefone.repositories.TelefoneParticipanteRepository;

@Service
public class TelefoneParticipanteService {

	@Autowired
	private TelefoneParticipanteRepository repository;

	public List<TelefoneParticipante> findAll() {
		return repository.findAll();
	}

	public Optional<TelefoneParticipante> findById(Long id) {
		return repository.findById(id);
	}

	public TelefoneParticipante save(TelefoneParticipante telefone) {
		return repository.save(telefone);
	}

	public TelefoneParticipante update(Long id, TelefoneParticipante telefoneDetails) {
		return repository.findById(id).map(telefone -> {
			telefone.setNroTelefone(telefoneDetails.getNroTelefone());
			telefone.setCodigoArea(telefoneDetails.getCodigoArea());
			telefone.setParticipanteId(telefoneDetails.getParticipanteId());
			return repository.save(telefone);
		}).orElseThrow(() -> new RuntimeException("TelefoneParticipante não encontrado com id: " + id));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}

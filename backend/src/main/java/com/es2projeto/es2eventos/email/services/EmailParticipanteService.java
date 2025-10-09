package com.es2projeto.es2eventos.email.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.es2projeto.es2eventos.email.entities.EmailParticipante;
import com.es2projeto.es2eventos.email.repositories.EmailParticipanteRepository;

@Service
public class EmailParticipanteService {

	private final EmailParticipanteRepository repository;

	public EmailParticipanteService(EmailParticipanteRepository repository) {
		this.repository = repository;
	}

	public List<EmailParticipante> findAll() {
		return repository.findAll();
	}

	public Optional<EmailParticipante> findById(Long id) {
		return repository.findById(id);
	}

	public EmailParticipante save(EmailParticipante email) {
		return repository.save(email);
	}

	public EmailParticipante update(Long id, EmailParticipante email) {
		return repository.findById(id).map(existing -> {
			existing.setEnderecoEmail(email.getEnderecoEmail());
			existing.setParticipanteId(email.getParticipanteId());
			return repository.save(existing);
		}).orElseThrow(() -> new RuntimeException("EmailParticipante não encontrado com id " + id));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}

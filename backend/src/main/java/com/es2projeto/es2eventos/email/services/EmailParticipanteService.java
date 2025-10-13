package com.es2projeto.es2eventos.email.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es2projeto.es2eventos.email.entities.EmailParticipante;
import com.es2projeto.es2eventos.email.repositories.EmailParticipanteRepository;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.participante.repositories.ParticipanteRepository;

@Service
public class EmailParticipanteService {

	private final EmailParticipanteRepository emailRepository;
	private final ParticipanteRepository participanteRepository;

	public EmailParticipanteService(EmailParticipanteRepository emailRepository,
			ParticipanteRepository participanteRepository) {
		this.emailRepository = emailRepository;
		this.participanteRepository = participanteRepository;
	}

	@Transactional(readOnly = true)
	public List<EmailParticipante> findAll() {
		return emailRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<EmailParticipante> findById(Long id) {
		return emailRepository.findById(id);
	}

	@Transactional
	public EmailParticipante save(EmailParticipante email) {
		// Certificar que o participante existe
		Long participanteId = email.getParticipante().getId();
		Participante participante = participanteRepository.findById(participanteId)
				.orElseThrow(() -> new RuntimeException("Participante não encontrado com id " + participanteId));

		email.setParticipante(participante);
		return emailRepository.save(email);
	}

	@Transactional
	public EmailParticipante update(Long id, EmailParticipante email) {
		return emailRepository.findById(id).map(existing -> {
			existing.setEnderecoEmail(email.getEnderecoEmail());

			// Atualizar participante, se necessário
			if (email.getParticipante() != null) {
				Long participanteId = email.getParticipante().getId();
				Participante participante = participanteRepository.findById(participanteId).orElseThrow(
						() -> new RuntimeException("Participante não encontrado com id " + participanteId));
				existing.setParticipante(participante);
			}

			return emailRepository.save(existing);
		}).orElseThrow(() -> new RuntimeException("EmailParticipante não encontrado com id " + id));
	}

	public void delete(Long id) {
		emailRepository.deleteById(id);
	}
}
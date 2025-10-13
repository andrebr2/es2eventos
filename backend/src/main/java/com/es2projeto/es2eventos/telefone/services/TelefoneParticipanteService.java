package com.es2projeto.es2eventos.telefone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.participante.repositories.ParticipanteRepository;
import com.es2projeto.es2eventos.telefone.entities.TelefoneParticipante;
import com.es2projeto.es2eventos.telefone.repositories.TelefoneParticipanteRepository;

@Service
public class TelefoneParticipanteService {

	private final TelefoneParticipanteRepository telefoneRepository;
	private final ParticipanteRepository participanteRepository;

	public TelefoneParticipanteService(TelefoneParticipanteRepository telefoneRepository,
			ParticipanteRepository participanteRepository) {
		this.telefoneRepository = telefoneRepository;
		this.participanteRepository = participanteRepository;
	}

	@Transactional(readOnly = true)
	public List<TelefoneParticipante> findAll() {
		return telefoneRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<TelefoneParticipante> findById(Long id) {
		return telefoneRepository.findById(id);
	}

	@Transactional
	public TelefoneParticipante save(TelefoneParticipante telefone, Long participanteId) {
		Participante participante = participanteRepository.findById(participanteId)
				.orElseThrow(() -> new RuntimeException("Participante não encontrado com id " + participanteId));
		telefone.setParticipante(participante);
		return telefoneRepository.save(telefone);
	}

	@Transactional
	public TelefoneParticipante update(Long id, TelefoneParticipante telefoneDetails, Long participanteId) {
		return telefoneRepository.findById(id).map(telefone -> {
			telefone.setNroTelefone(telefoneDetails.getNroTelefone());
			telefone.setCodigoArea(telefoneDetails.getCodigoArea());

			Participante participante = participanteRepository.findById(participanteId)
					.orElseThrow(() -> new RuntimeException("Participante não encontrado com id " + participanteId));
			telefone.setParticipante(participante);

			return telefoneRepository.save(telefone);
		}).orElseThrow(() -> new RuntimeException("TelefoneParticipante não encontrado com id " + id));
	}

	public void delete(Long id) {
		telefoneRepository.deleteById(id);
	}
}
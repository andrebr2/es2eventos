package com.es2projeto.es2eventos.inscricao.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es2projeto.es2eventos.inscricao.DTO.InscricaoDTO;
import com.es2projeto.es2eventos.inscricao.entities.Inscricao;
import com.es2projeto.es2eventos.inscricao.repositories.InscricaoRepository;
import com.es2projeto.es2eventos.palestra.repositories.PalestraRepository;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.participante.repositories.ParticipanteRepository;

@Service
public class InscricaoService {

	private final InscricaoRepository inscricaoRepository;
	private final PalestraRepository palestraRepository;
	private final ParticipanteRepository participanteRepository;

	public InscricaoService(InscricaoRepository inscricaoRepository, PalestraRepository palestraRepository,
			ParticipanteRepository participanteRepository) {
		this.inscricaoRepository = inscricaoRepository;
		this.palestraRepository = palestraRepository;
		this.participanteRepository = participanteRepository;
	}

	@Transactional(readOnly = true)
	public List<InscricaoDTO> findAll() {
		return inscricaoRepository.findAll().stream().map(InscricaoDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public InscricaoDTO findById(Long id) {
		var inscricao = inscricaoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Inscrição não encontrada"));
		return new InscricaoDTO(inscricao);
	}

	@Transactional
	public InscricaoDTO save(InscricaoDTO dto) {

	    Long palestraId = dto.getPalestra().getId();
	    var palestra = palestraRepository.findById(palestraId)
	            .orElseThrow(() -> new RuntimeException("Palestra não encontrada"));

	    Long participanteId = dto.getParticipante().getId();
	    Participante participante = participanteRepository.findById(participanteId)
	            .orElseThrow(() -> new RuntimeException("Participante não encontrado"));

	    Inscricao entity = new Inscricao();
	    entity.setPalestra(palestra);
	    entity.setParticipante(participante);
	    entity.setDataHoraInscricao(LocalDateTime.now());

	    inscricaoRepository.save(entity);
	    return new InscricaoDTO(entity);
	}

	public void delete(Long id) {
		if (!inscricaoRepository.existsById(id)) {
			throw new RuntimeException("Inscrição não encontrada para exclusão");
		}
		inscricaoRepository.deleteById(id);
	}
}
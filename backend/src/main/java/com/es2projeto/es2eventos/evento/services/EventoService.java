package com.es2projeto.es2eventos.evento.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es2projeto.es2eventos.evento.entities.Evento;
import com.es2projeto.es2eventos.evento.repositories.EventoRepository;
import com.es2projeto.es2eventos.palestra.dto.PalestraDTO;
import com.es2projeto.es2eventos.palestra.entities.Palestra;
import com.es2projeto.es2eventos.palestra.repositories.PalestraRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventoService {

	@Autowired
	EventoRepository repository;

	@Autowired
	PalestraRepository palestraRepository;
	
	@Transactional(readOnly = true)
	public List<Evento> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Evento findById(Long id) {
		Optional<Evento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new EntityNotFoundException("Evento não encontrado com ID: " + id));
	}
	
	public List<PalestraDTO> findProximasPalestras(Long eventoId) {
        LocalDateTime agora = LocalDateTime.now();
        return palestraRepository.findByEventoIdAndDataHoraAfter(eventoId, agora)
                .stream()
                .map(PalestraDTO::new)
                .collect(Collectors.toList());
    }

	@Transactional
	public Evento insert(Evento evento) {
		if (evento.getPalestras() != null) {
			for (Palestra p : evento.getPalestras()) {
				p.setEvento(evento); // garante vínculo bidirecional
			}
		}
		return repository.save(evento);
	}

	@Transactional
	public Evento update(Long id, Evento novoEvento) {
		Evento evento = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Evento não encontrado com ID: " + id));

		evento.setNomeEvento(novoEvento.getNomeEvento());
		evento.setDataInicio(novoEvento.getDataInicio());
		evento.setDataTermino(novoEvento.getDataTermino());
		evento.setLocal(novoEvento.getLocal());
		evento.setDescricao(novoEvento.getDescricao());
		evento.setSite(novoEvento.getSite());

		if (novoEvento.getPalestras() != null) {
			evento.getPalestras().clear();
			for (Palestra p : novoEvento.getPalestras()) {
				evento.addPalestra(p);
			}
		}

		return repository.save(evento);
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new EntityNotFoundException("Evento não encontrado com ID: " + id);
		}
		repository.deleteById(id);
	}

}
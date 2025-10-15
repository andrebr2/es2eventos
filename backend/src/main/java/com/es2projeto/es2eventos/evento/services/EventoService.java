package com.es2projeto.es2eventos.evento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es2projeto.es2eventos.evento.entities.Evento;
import com.es2projeto.es2eventos.evento.repositories.EventoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventoService {

	@Autowired
	EventoRepository repository;
	
	// Retorna todos os eventos
    public List<Evento> findAll() {
        return repository.findAll();
    }

    // Busca um evento por ID
    public Evento findById(Long id) {
        Optional<Evento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Evento não encontrado com ID: " + id));
    }

    // Cria um novo evento
    public Evento insert(Evento evento) {
        return repository.save(evento);
    }

    // Atualiza um evento existente
    public Evento update(Long id, Evento novoEvento) {
        Evento evento = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado com ID: " + id));

        evento.setNomeEvento(novoEvento.getNomeEvento());
        evento.setDataInicio(novoEvento.getDataInicio());
        evento.setDataTermino(novoEvento.getDataTermino());
        evento.setLocal(novoEvento.getLocal());
        evento.setDescricao(novoEvento.getDescricao());
        evento.setSite(novoEvento.getSite());

        return repository.save(evento);
    }

    // Exclui um evento por ID
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Evento não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
	
}

package com.es2projeto.es2eventos.palestra.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es2projeto.es2eventos.evento.repositories.EventoRepository;
import com.es2projeto.es2eventos.palestra.entities.Palestra;
import com.es2projeto.es2eventos.palestra.repositories.PalestraRepository;


@Service
public class PalestraService {

	@Autowired
    private PalestraRepository repository;
	
	@Autowired
    private EventoRepository eventoRepository;

	@Transactional(readOnly = true)
    public List<Palestra> findAll() {
        return repository.findAll();
    }

	@Transactional(readOnly = true)
    public Palestra findById(Long id) {
        Optional<Palestra> obj = repository.findById(id);
        return obj.orElse(null);
    }

    
    @Transactional
    public Palestra insert(Palestra palestra) {
        validarConflitoDeHorario(palestra);
        return repository.save(palestra);
    }

    @Transactional
    public Palestra update(Long id, Palestra novaPalestra) {
        Palestra entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palestra não encontrada com id " + id));

        entity.setNomePalestra(novaPalestra.getNomePalestra());
        entity.setDataHora(novaPalestra.getDataHora());
        entity.setPalestrante(novaPalestra.getPalestrante());
        entity.setLimiteVagas(novaPalestra.getLimiteVagas());
        entity.setLocal(novaPalestra.getLocal());
        entity.setEvento(novaPalestra.getEvento());
        validarConflitoDeHorario(entity);

        return repository.save(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Palestra não encontrada com id " + id);
        }
        repository.deleteById(id);
    }

    
    private void validarConflitoDeHorario(Palestra palestra) {
        List<Palestra> palestrasDoMesmoPalestrante = repository.findByPalestrante(palestra.getPalestrante());

        for (Palestra p : palestrasDoMesmoPalestrante) {
            // Ignora a própria palestra em caso de update
            if (p.getId() != null && palestra.getId() != null && p.getId().equals(palestra.getId())) {
                continue;
            }

            LocalDateTime dataHora1 = palestra.getDataHora();
            LocalDateTime dataHora2 = p.getDataHora();

            if (dataHora1.equals(dataHora2)) {
                throw new RuntimeException("Conflito de horário: o palestrante já está em outra palestra neste mesmo horário.");
            }
        }
    }
}
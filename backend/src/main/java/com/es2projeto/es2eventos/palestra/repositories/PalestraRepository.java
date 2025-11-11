package com.es2projeto.es2eventos.palestra.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es2projeto.es2eventos.palestra.entities.Palestra;

public interface PalestraRepository extends JpaRepository<Palestra, Long> {
	
    List<Palestra> findByEventoId(Long eventoId);

	List<Palestra> findByPalestrante(String palestrante);
	
	List<Palestra> findByEventoIdAndDataHoraAfter(Long eventoId, LocalDateTime dataHoraAtual);
	
}
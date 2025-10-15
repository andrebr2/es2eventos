package com.es2projeto.es2eventos.evento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.es2projeto.es2eventos.evento.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}
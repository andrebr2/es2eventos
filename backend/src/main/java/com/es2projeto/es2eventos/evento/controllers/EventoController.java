package com.es2projeto.es2eventos.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.evento.entities.Evento;
import com.es2projeto.es2eventos.evento.services.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	 @Autowired
	    private EventoService service;

	    @GetMapping
	    public ResponseEntity<List<Evento>> findAll() {
	        List<Evento> list = service.findAll();
	        return ResponseEntity.ok(list);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Evento> findById(@PathVariable Long id) {
	        Evento obj = service.findById(id);
	        return ResponseEntity.ok(obj);
	    }

	    @PostMapping
	    public ResponseEntity<Evento> insert(@RequestBody Evento evento) {
	        Evento obj = service.insert(evento);
	        return ResponseEntity.ok(obj);
	    }

	    // 🔹 PUT - Atualiza evento existente
	    @PutMapping("/{id}")
	    public ResponseEntity<Evento> update(@PathVariable Long id, @RequestBody Evento evento) {
	        Evento obj = service.update(id, evento);
	        return ResponseEntity.ok(obj);
	    }

	    // 🔹 DELETE - Exclui evento
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
	
}

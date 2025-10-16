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

import com.es2projeto.es2eventos.palestra.entities.Palestra;
import com.es2projeto.es2eventos.palestra.services.PalestraService;

@RestController
@RequestMapping("/palestras")
public class PalestraController {

	 @Autowired
	    private PalestraService service;
	    
	    @GetMapping
	    public ResponseEntity<List<Palestra>> findAll() {
	        List<Palestra> list = service.findAll();
	        return ResponseEntity.ok().body(list);
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Palestra> findById(@PathVariable Long id) {
	        Palestra palestra = service.findById(id);
	        if (palestra == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(palestra);
	    }
	    
	    @PostMapping
	    public ResponseEntity<Palestra> insert(@RequestBody Palestra palestra) {
	        Palestra nova = service.insert(palestra);
	        return ResponseEntity.ok().body(nova);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Palestra> update(@PathVariable Long id, @RequestBody Palestra palestra) {
	        Palestra atualizada = service.update(id, palestra);
	        return ResponseEntity.ok().body(atualizada);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }
}
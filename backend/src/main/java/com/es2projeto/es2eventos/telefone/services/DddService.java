package com.es2projeto.es2eventos.telefone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es2projeto.es2eventos.telefone.entities.DDD;
import com.es2projeto.es2eventos.telefone.repositories.DddRepository;

@Service
public class DddService {

    @Autowired
    private DddRepository dddRepository;

    public List<DDD> findAll() {
        return dddRepository.findAll();
    }

    public Optional<DDD> findById(int codigoArea) {
        return dddRepository.findById(codigoArea);
    }

    public DDD save(DDD ddd) {
        return dddRepository.save(ddd);
    }

    public void delete(int codigoArea) {
        dddRepository.deleteById(codigoArea);
    }
}

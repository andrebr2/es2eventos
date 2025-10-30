package com.es2projeto.es2eventos.endereco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.es2projeto.es2eventos.endereco.dto.EnderecoDTO;
import com.es2projeto.es2eventos.endereco.entities.Endereco;
import com.es2projeto.es2eventos.endereco.repositories.EnderecoRepository;
import com.es2projeto.es2eventos.endereco.services.ViaCepService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ViaCepService viaCepService;

	@PostMapping
	public EnderecoDTO cadastrarEndereco(@RequestBody EnderecoDTO dto) {
		Endereco enderecoViaCep = viaCepService.buscarEnderecoPorCep(dto.getCep());
		Endereco salvo = enderecoRepository.save(enderecoViaCep);
		return new EnderecoDTO(salvo);
	}

	@GetMapping
	public List<EnderecoDTO> listarTodos() {
		return enderecoRepository.findAll().stream().map(EnderecoDTO::new).toList();
	}

	@GetMapping("/{id}")
	public Endereco buscarPorId(@PathVariable Long id) {
		return enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado!"));
	}
}
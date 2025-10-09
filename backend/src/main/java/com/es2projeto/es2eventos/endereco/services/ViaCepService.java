package com.es2projeto.es2eventos.endereco.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.es2projeto.es2eventos.endereco.entities.Endereco;

@Service
public class ViaCepService {

	private static final String URL_VIACEP = "https://viacep.com.br/ws/{cep}/json/";

	public Endereco buscarEnderecoPorCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String url = UriComponentsBuilder.fromUriString(URL_VIACEP).buildAndExpand(cep).toUriString();

		Endereco endereco = restTemplate.getForObject(url, Endereco.class);
		if (endereco == null || endereco.getCep() == null) {
			throw new RuntimeException("CEP não encontrado: " + cep);
		}
		return endereco;
	}
}
package com.es2projeto.es2eventos.participante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.es2projeto.es2eventos.endereco.entities.Endereco;
import com.es2projeto.es2eventos.endereco.repositories.EnderecoRepository;
import com.es2projeto.es2eventos.participante.dto.ParticipanteDTO;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.participante.repositories.ParticipanteRepository;
import com.es2projeto.es2eventos.tipo.entities.TipoParticipante;
import com.es2projeto.es2eventos.tipo.repositories.TipoParticipanteRepository;

@Service
public class ParticipanteService {

	private final ParticipanteRepository participanteRepository;
	private final TipoParticipanteRepository tipoParticipanteRepository;
	private final EnderecoRepository enderecoRepository;
	private final RestTemplate restTemplate;

	// Injetando todos os repositórios + RestTemplate
	public ParticipanteService(ParticipanteRepository participanteRepository,
			TipoParticipanteRepository tipoParticipanteRepository, EnderecoRepository enderecoRepository,
			RestTemplate restTemplate) {
		this.participanteRepository = participanteRepository;
		this.tipoParticipanteRepository = tipoParticipanteRepository;
		this.enderecoRepository = enderecoRepository;
		this.restTemplate = restTemplate;
	}

	public List<Participante> findAll() {
		return participanteRepository.findAll();
	}

	public Optional<Participante> findById(Long id) {
		return participanteRepository.findById(id);
	}

	@Transactional
	public Participante save(ParticipanteDTO dto) {
		Endereco endereco = verificarOuCadastrarEndereco(dto.getCep());

		TipoParticipante tipo = tipoParticipanteRepository.findById(dto.getTipoParticipanteId())
				.orElseThrow(() -> new RuntimeException("TipoParticipante não encontrado"));

		Participante participante = new Participante(dto.getNome(), dto.getSobrenome(), tipo, dto.getNumero(),
				dto.getComplemento(), endereco);

		return participanteRepository.save(participante);
	}

	@Transactional
	public Participante update(Long id, ParticipanteDTO dto) {
		return participanteRepository.findById(id).map(participante -> {
			participante.setNome(dto.getNome());
			participante.setSobrenome(dto.getSobrenome());

			TipoParticipante tipo = tipoParticipanteRepository.findById(dto.getTipoParticipanteId())
					.orElseThrow(() -> new RuntimeException("TipoParticipante não encontrado"));
			participante.setTipoParticipante(tipo);

			participante.setNumero(dto.getNumero());
			participante.setComplemento(dto.getComplemento());
			participante.setEndereco(verificarOuCadastrarEndereco(dto.getCep()));

			return participanteRepository.save(participante);
		}).orElseThrow(() -> new RuntimeException("Participante não encontrado"));
	}

	public void delete(Long id) {
		participanteRepository.deleteById(id);
	}

	private Endereco verificarOuCadastrarEndereco(String cep) {
		if (cep == null || cep.isEmpty())
			return null;

		return enderecoRepository.findByCep(cep).orElseGet(() -> {
			String url = "https://viacep.com.br/ws/" + cep + "/json/";
			Endereco endereco = restTemplate.getForObject(url, Endereco.class);
			return enderecoRepository.save(endereco);
		});
	}
}

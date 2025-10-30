package com.es2projeto.es2eventos.participante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es2projeto.es2eventos.auth.entity.Role;
import com.es2projeto.es2eventos.endereco.entities.Endereco;
import com.es2projeto.es2eventos.endereco.repositories.EnderecoRepository;
import com.es2projeto.es2eventos.endereco.services.ViaCepService;
import com.es2projeto.es2eventos.participante.dto.ParticipanteCadastroDTO;
import com.es2projeto.es2eventos.participante.dto.ParticipanteDTO;
import com.es2projeto.es2eventos.participante.entities.Participante;
import com.es2projeto.es2eventos.participante.repositories.ParticipanteRepository;
import com.es2projeto.es2eventos.tipo.entities.TipoParticipante;
import com.es2projeto.es2eventos.tipo.repositories.TipoParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private TipoParticipanteRepository tipoParticipanteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ViaCepService viaCepService;

	@Transactional(readOnly = true)
	public List<Participante> findAll() {
		return participanteRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Participante> findById(Long id) {
		return participanteRepository.findById(id);
	}

	@Transactional
	public Participante registrarParticipante(ParticipanteCadastroDTO dto) {
		if (dto.getEndereco() == null || dto.getEndereco().getCep() == null || dto.getEndereco().getCep().isEmpty()) {
			throw new IllegalArgumentException("CEP não pode ser vazio");
		}

		Endereco endereco = enderecoRepository.findByCep(dto.getEndereco().getCep()).orElseGet(() -> {
			Endereco viaCepEndereco = viaCepService.buscarEnderecoPorCep(dto.getEndereco().getCep());
			return enderecoRepository.save(viaCepEndereco);
		});

		TipoParticipante tipo = tipoParticipanteRepository.findById(dto.getTipoParticipante().getId())
				.orElseThrow(() -> new RuntimeException("TipoParticipante não encontrado"));

		Participante participante = new Participante();
		participante.setEmail(dto.getEmail());
		participante.setSenha(passwordEncoder.encode(dto.getSenha()));
		participante.setRole(Role.PARTICIPANTE);
		participante.setNome(dto.getNome());
		participante.setSobrenome(dto.getSobrenome());
		participante.setTelefone(dto.getTelefone());
		participante.setTipoParticipante(tipo);
		participante.setNumero(dto.getNumero());
		participante.setComplemento(dto.getComplemento());
		participante.setEndereco(endereco);

		return participanteRepository.save(participante);
	}

	@Transactional
	public Participante update(Long id, ParticipanteDTO dto) {
		return participanteRepository.findById(id).map(participante -> {
			participante.setNome(dto.getNome());
			participante.setSobrenome(dto.getSobrenome());
			participante.setTelefone(dto.getTelefone());

			TipoParticipante tipo = tipoParticipanteRepository.findById(dto.getTipoParticipante().getId())
					.orElseThrow(() -> new RuntimeException("TipoParticipante não encontrado"));
			participante.setTipoParticipante(tipo);

			participante.setNumero(dto.getNumero());
			participante.setComplemento(dto.getComplemento());

			if (dto.getEndereco() != null && dto.getEndereco().getCep() != null) {
				participante.setEndereco(buscarOuCriarEndereco(dto.getEndereco().getCep()));
			}

			return participanteRepository.save(participante);
		}).orElseThrow(() -> new RuntimeException("Participante não encontrado"));
	}

	public void delete(Long id) {
		participanteRepository.deleteById(id);
	}

	private Endereco buscarOuCriarEndereco(String cep) {
		if (cep == null || cep.isEmpty())
			throw new IllegalArgumentException("CEP não pode ser vazio");

		return enderecoRepository.findByCep(cep).orElseGet(() -> {

			Endereco endereco = viaCepService.buscarEnderecoPorCep(cep);

			if (endereco.getLogradouro() == null || endereco.getBairro() == null || endereco.getLocalidade() == null
					|| endereco.getUf() == null) {
				throw new RuntimeException("Endereço retornado pelo CEP " + cep + " está incompleto");
			}

			return enderecoRepository.save(endereco);
		});
	}

}
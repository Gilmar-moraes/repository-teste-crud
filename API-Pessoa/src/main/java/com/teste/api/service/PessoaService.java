package com.teste.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.teste.api.exception.NegocioException;
import com.teste.api.model.PessoaModel;
import com.teste.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<PessoaModel> listarPessoas() {
		return pessoaRepository.findAll();
	}
	
	public PessoaModel buscarPessoa(Long pessoaId) {
		return pessoaRepository.findById(pessoaId)
				.orElseThrow(() -> new NegocioException("Cadastro da pessoa não encontrado"));
	}

	@Transactional
	public PessoaModel salvarPessoa(PessoaModel pessoaModel) {
		boolean nomeEmUso = pessoaRepository.findByNome(pessoaModel.getNome()).stream()
				.anyMatch(pessoaExiste -> !pessoaExiste.equals(pessoaModel));
		if (nomeEmUso) {
			throw new NegocioException("Cadastro de pesssoa já existe!");
		}
		return pessoaRepository.save(pessoaModel);
	}

	@Transactional
	public PessoaModel atualizarPessoa(Long pessoaId, PessoaModel pessoaAtualizar) {

		Optional<PessoaModel> pessoaOptional = pessoaRepository.findById(pessoaId);

		if (pessoaOptional.isPresent()) {
			PessoaModel pessoaAtual = pessoaOptional.get();

			pessoaAtual.setNome(pessoaAtualizar.getNome());
			pessoaAtual.setDataNascimento(pessoaAtualizar.getDataNascimento());
			pessoaAtual.setEndereco(pessoaAtualizar.getEndereco());

			return pessoaRepository.save(pessoaAtual);
		} else {
			throw new NegocioException("Pessoa não encontrada com o ID: " + pessoaId);
		}
	}

	@Transactional
	public void excluirPessoa(Long pessoaId) {
		pessoaRepository.deleteById(pessoaId);
	}
}

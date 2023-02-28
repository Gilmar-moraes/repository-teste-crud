package com.teste.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.api.exception.NegocioException;
import com.teste.api.model.EnderecoModel;
import com.teste.api.model.PessoaModel;
import com.teste.api.repository.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

	@Autowired
    private EnderecoRepository enderecoRepository;
    
	public List<EnderecoModel> listarEndereco(){
		return enderecoRepository.findAll();
	}
	
    public EnderecoModel consultarEndereco(Long id) {
        return enderecoRepository.findById(id)
            .orElseThrow(() -> new NegocioException("Endereço não encontrado"));
    }
    
    @Transactional
    public EnderecoModel salvarEndereco(Long pessoaId, EnderecoModel endereco) {
        PessoaModel pessoa = new PessoaModel();
        pessoa.setId(pessoaId);
        endereco.setPessoaModel(pessoa);
        return enderecoRepository.save(endereco);
    }
   /* 
    public EnderecoModel definirPrincipal(Long pessoaId, Long enderecoId) {
        PessoaModel pessoa = new PessoaModel();
        pessoa.setId(pessoaId);
        
        EnderecoModel enderecoPrincipal = enderecoRepository.findByPessoaAndPrincipal(pessoa, true);
        if (enderecoPrincipal != null) {
            enderecoPrincipal.setPrincipal(false);
            enderecoRepository.save(enderecoPrincipal);
        }
        
        EnderecoModel endereco = enderecoRepository.findById(enderecoId)
            .orElseThrow(() -> new NegocioException("Endereço não encontrado"));
        endereco.setPrincipal(true);
        return enderecoRepository.save(endereco);
    }*/
}

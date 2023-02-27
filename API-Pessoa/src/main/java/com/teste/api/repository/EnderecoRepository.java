package com.teste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.api.model.EnderecoModel;
import com.teste.api.model.PessoaModel;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long>{
	
	public EnderecoModel findByPessoaAndPrincipal(PessoaModel pessoa, boolean isPrincipal);

}

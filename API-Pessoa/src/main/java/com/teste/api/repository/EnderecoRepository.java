package com.teste.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.api.model.EnderecoModel;
import com.teste.api.model.PessoaModel;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, Long>{
	
	
}

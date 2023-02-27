package com.teste.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.api.model.PessoaModel;
import com.teste.api.service.PessoaService;

@RequestMapping("/pessoas")
public class PessoaController {
	
	    @Autowired
	    private PessoaService pessoaService;
	    
	    @GetMapping
	    public List<PessoaModel> listarPessoas() {
	        return pessoaService.listarPessoas();
	    }
	    
	    @GetMapping("/{id}")
	    public PessoaModel consultarPessoa(@PathVariable Long id) {
	        return pessoaService.buscarPessoa(id);
	    }
	    
	    @PostMapping
	    public PessoaModel criarPessoa(@RequestBody PessoaModel pessoa) {
	        return pessoaService.salvarPessoa(pessoa);
	    }
	    
	    @PutMapping("/{id}")
	    public PessoaModel atualizaPessoa(@PathVariable Long id, @RequestBody PessoaModel pessoa) {
	        return pessoaService.atualizarPessoa(id, pessoa);
	    }
}

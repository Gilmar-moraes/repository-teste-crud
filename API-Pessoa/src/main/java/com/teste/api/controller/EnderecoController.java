package com.teste.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.api.model.EnderecoModel;
import com.teste.api.service.EnderecoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
    @PostMapping("/{pessoaId}")
    public EnderecoModel criarEndereco(@PathVariable Long pessoaId, @RequestBody @Valid EnderecoModel endereco) {
        return enderecoService.salvarEndereco(pessoaId, endereco);
    }
    
    @GetMapping
    public List<EnderecoModel> listarEnderecos() {
        return enderecoService.listarEndereco();
    }
    
    @GetMapping("/{id}")
    public EnderecoModel consultarEndereco(@PathVariable Long id) {
        return enderecoService.consultarEndereco(id);
    }
    /*
    @PutMapping("/{id}/principal")
    public EnderecoModel escolhePrincipal(@PathVariable Long pessoaId, @PathVariable Long id) {
        return enderecoService.definirPrincipal(pessoaId, id);
    }*/
}

package com.teste.api.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_endereco")
public class EnderecoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String lougradouro;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String cidade;
	
    private boolean principal;

	@ManyToOne
    @JoinColumn(name = "pessoa_id")
	private PessoaModel pessoa_id;
	
	public EnderecoModel() {
		// TODO Auto-generated constructor stub
	}

	public EnderecoModel(Long id, String lougradouro, String cep, String numero, String cidade,
			boolean principal,PessoaModel pessoa_id) {
		super();
		this.id = id;
		this.lougradouro = lougradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.pessoa_id = pessoa_id;
		this.principal = principal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLougradouro() {
		return lougradouro;
	}

	public void setLougradouro(String lougradouro) {
		this.lougradouro = lougradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public PessoaModel getPessoaModel() {
		return pessoa_id;
	}

	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoa_id = pessoaModel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoModel other = (EnderecoModel) obj;
		return Objects.equals(id, other.id);
	}
}

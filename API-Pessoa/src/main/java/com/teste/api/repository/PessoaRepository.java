/**
 * Classe repositorio é resposavel
 * por conte a assinatura dos metodos
 * que serão utilizando para fazer a 
 * persistencia com a base de dados
 * 
 * @author Gilmar Junior
 * @since 22/02/2027
 * @version 1
 **/

package com.teste.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.api.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
	
	List<PessoaModel> findByNome(String nome);
	
	/**
	 * Assinatura do metodo que busca por informações que contenham 
	 * determinados caracteres passado como paramentos.
	 * @param um nome ou um caracter para realizar a busca.
	 * @return registros que contenham o caracter.
	 * 
	 */
	List<PessoaModel> findByNomeContaining(String nome);
}

package br.edu.fjn.maternidade.application;

import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface PessoaFisicaApplication {

	void inserir(PessoaFisica entidade) throws MaternidadeException;

	void alterar(PessoaFisica entidade) throws MaternidadeException;

	void apagar(PessoaFisica entidade);
	
	PessoaFisica buscarPorId(Integer id) throws MaternidadeException;
	
}

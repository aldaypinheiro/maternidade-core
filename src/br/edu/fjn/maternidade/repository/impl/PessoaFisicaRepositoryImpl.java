package br.edu.fjn.maternidade.repository.impl;

import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisicaRepository;

public class PessoaFisicaRepositoryImpl extends
		AbstractRepositoryImpl<PessoaFisica, Integer> implements
		PessoaFisicaRepository {

	public PessoaFisicaRepositoryImpl() {
		super(PessoaFisica.class);
	}

}

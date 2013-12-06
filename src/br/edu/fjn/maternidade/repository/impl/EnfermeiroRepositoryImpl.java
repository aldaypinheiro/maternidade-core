package br.edu.fjn.maternidade.repository.impl;

import br.edu.fjn.maternidade.domain.enfermeiro.Enfermeiro;
import br.edu.fjn.maternidade.domain.enfermeiro.EnfermeiroRepository;

public class EnfermeiroRepositoryImpl extends
		AbstractRepositoryImpl<Enfermeiro, Integer> implements
		EnfermeiroRepository {

	public EnfermeiroRepositoryImpl() {
		super(Enfermeiro.class);
	}

}

package br.edu.fjn.maternidade.repository.impl;

import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.domain.especialidade.EspecialidadeRepository;

public class EspecialidadeRepositoryImpl extends
		AbstractRepositoryImpl<Especialidade, Integer> implements
		EspecialidadeRepository {

	public EspecialidadeRepositoryImpl() {
		super(Especialidade.class);
	}

}

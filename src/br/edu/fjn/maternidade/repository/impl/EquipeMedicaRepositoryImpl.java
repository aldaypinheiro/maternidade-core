package br.edu.fjn.maternidade.repository.impl;

import br.edu.fjn.maternidade.domain.equipemedica.EquipeMedica;
import br.edu.fjn.maternidade.domain.equipemedica.EquipeMedicaRepository;

public class EquipeMedicaRepositoryImpl extends
		AbstractRepositoryImpl<EquipeMedica, Integer> implements
		EquipeMedicaRepository {

	public EquipeMedicaRepositoryImpl() {
		super(EquipeMedica.class);
	}

}

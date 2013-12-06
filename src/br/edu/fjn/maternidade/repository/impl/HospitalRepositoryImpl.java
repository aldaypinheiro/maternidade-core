package br.edu.fjn.maternidade.repository.impl;

import br.edu.fjn.maternidade.domain.hospital.Hospital;
import br.edu.fjn.maternidade.domain.hospital.HospitalRepository;

public class HospitalRepositoryImpl extends
		AbstractRepositoryImpl<Hospital, Integer> implements HospitalRepository {

	public HospitalRepositoryImpl() {
		super(Hospital.class);
	}

}

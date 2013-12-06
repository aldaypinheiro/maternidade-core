package br.edu.fjn.maternidade.application.impl;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.edu.fjn.maternidade.application.HospitalApplication;
import br.edu.fjn.maternidade.domain.hospital.Hospital;
import br.edu.fjn.maternidade.domain.hospital.HospitalRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.HospitalRepositoryImpl;

public class HospitalApplicationImpl implements HospitalApplication {

	private HospitalRepository repository = new HospitalRepositoryImpl();
	private CNPJValidator cnpjValidador = new CNPJValidator(true);
	
	@Override
	public void alterar(Hospital hospital) throws MaternidadeException {
		try {
			cnpjValidador.assertValid(hospital.getCnpj());
		} catch (InvalidStateException e) {
			throw new MaternidadeException("CNPJ Inválido!");
		}
		repository.alterar(hospital);
	}

	@Override
	public void apagar(Hospital hospital) {
		repository.apagar(hospital);
	}

	@Override
	public Hospital getHospital() {
		return repository.buscarPorId(1);
	}


}

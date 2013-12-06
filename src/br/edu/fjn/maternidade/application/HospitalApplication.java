package br.edu.fjn.maternidade.application;

import br.edu.fjn.maternidade.domain.hospital.Hospital;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface HospitalApplication {

	void alterar(Hospital hospital) throws MaternidadeException;

	void apagar(Hospital hospital);
	
	Hospital getHospital();
		
}

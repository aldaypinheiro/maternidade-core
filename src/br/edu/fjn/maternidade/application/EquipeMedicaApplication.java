package br.edu.fjn.maternidade.application;

import java.util.List;

import br.edu.fjn.maternidade.domain.equipemedica.EquipeMedica;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface EquipeMedicaApplication {

	void inserir(EquipeMedica equipeMedica) throws MaternidadeException;

	void alterar(EquipeMedica equipeMedica) throws MaternidadeException;

	void apagar(EquipeMedica equipeMedica);
	
	EquipeMedica buscarPorId(Integer id) throws MaternidadeException;
	
	List<EquipeMedica> listar() throws MaternidadeException;
	
}

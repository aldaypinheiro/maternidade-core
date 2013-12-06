package br.edu.fjn.maternidade.application.impl;

import java.util.List;

import br.edu.fjn.maternidade.application.EquipeMedicaApplication;
import br.edu.fjn.maternidade.domain.equipemedica.EquipeMedica;
import br.edu.fjn.maternidade.domain.equipemedica.EquipeMedicaRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.EquipeMedicaRepositoryImpl;

public class EquipeMedicaApplicationImpl implements EquipeMedicaApplication {

	private EquipeMedicaRepository repository = new EquipeMedicaRepositoryImpl();

	@Override
	public void inserir(EquipeMedica equipeMedica) throws MaternidadeException {
		if (equipeMedica.getEnfermeiros().size() >= 2
				&& equipeMedica.getMedicos().size() >= 3)
			repository.inserir(equipeMedica);
		else
			throw new MaternidadeException(
					"A equipe m�dica n�o tem enfermeiros ou m�dicos suficientes.");
	}

	@Override
	public void alterar(EquipeMedica equipeMedica) throws MaternidadeException {
		if (equipeMedica.getEnfermeiros().size() >= 2
				&& equipeMedica.getMedicos().size() >= 3)
			repository.alterar(equipeMedica);
		else
			throw new MaternidadeException(
					"A equipe m�dica n�o tem enfermeiros ou m�dicos suficientes.");
	}

	@Override
	public void apagar(EquipeMedica equipeMedica) {
		repository.apagar(equipeMedica);
	}

	@Override
	public EquipeMedica buscarPorId(Integer id) throws MaternidadeException {
		EquipeMedica busca = repository.buscarPorId(id);
		
		if (busca == null) {
			throw new MaternidadeException("Não há registo de equipe médica cadastrado com esta id");
		}
		
		return busca;
	}

	@Override
	public List<EquipeMedica> listar() throws MaternidadeException {
		List<EquipeMedica> busca = repository.listar();
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException("Não há registros de equipes médicas cadastrados");
		}
		
		return busca;
	}

}

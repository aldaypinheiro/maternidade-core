package br.edu.fjn.maternidade.application.impl;

import java.util.List;

import br.edu.fjn.maternidade.application.EspecialidadeApplication;
import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.domain.especialidade.EspecialidadeRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.EspecialidadeRepositoryImpl;

public class EspecialidadeApplicationImpl implements EspecialidadeApplication {

	private EspecialidadeRepository repository = new EspecialidadeRepositoryImpl();

	@Override
	public void inserir(Especialidade especialidade) {
		repository.inserir(especialidade);
	}

	@Override
	public void alterar(Especialidade especialidade) {
		repository.alterar(especialidade);
	}

	@Override
	public void apagar(Especialidade especialidade) {
		repository.apagar(especialidade);
	}

	@Override
	public Especialidade buscarPorId(Integer id) throws MaternidadeException {
		Especialidade busca = repository.buscarPorId(id);
		
		if (busca == null) {
			throw new MaternidadeException("Não há registro de especialidade com esta id");
		}
		
		return busca;
	}

	@Override
	public List<Especialidade> listar() throws MaternidadeException {
		List<Especialidade> busca = repository.listar();
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException("Não há registros de especialidades cadastrados");
		}
		
		return busca;
	}

}

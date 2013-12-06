package br.edu.fjn.maternidade.application.impl;

import java.util.List;

import br.edu.fjn.maternidade.application.EnfermeiroApplication;
import br.edu.fjn.maternidade.domain.enfermeiro.Enfermeiro;
import br.edu.fjn.maternidade.domain.enfermeiro.EnfermeiroRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.EnfermeiroRepositoryImpl;

public class EnfermeiroApplicationImpl implements EnfermeiroApplication {

	private EnfermeiroRepository repository = new EnfermeiroRepositoryImpl();

	@Override
	public void inserir(Enfermeiro enfermeiro) {
		repository.inserir(enfermeiro);
	}

	@Override
	public void alterar(Enfermeiro enfermeiro) {
		repository.alterar(enfermeiro);
	}

	@Override
	public void apagar(Enfermeiro enfermeiro) {
		repository.apagar(enfermeiro);
	}

	@Override
	public Enfermeiro buscarPorId(Integer id) throws MaternidadeException {
		Enfermeiro busca = repository.buscarPorId(id);
		
		if (busca == null) {
			throw new MaternidadeException("Não há registro de enfermeiro com esta id");
		}
		
		return busca;
	}

	@Override
	public List<Enfermeiro> listar() throws MaternidadeException {
		List<Enfermeiro> busca = repository.listar();
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException("Não há registros de enfermeiros cadastrados");
		}
		
		return busca;
	}

}

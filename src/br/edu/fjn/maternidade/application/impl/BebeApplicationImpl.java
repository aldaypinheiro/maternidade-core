package br.edu.fjn.maternidade.application.impl;

import java.sql.Date;
import java.util.List;

import br.edu.fjn.maternidade.application.BebeApplication;
import br.edu.fjn.maternidade.domain.bebe.Bebe;
import br.edu.fjn.maternidade.domain.bebe.BebeRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.BebeRepositoryImpl;

public class BebeApplicationImpl implements BebeApplication {

	private BebeRepository repository = new BebeRepositoryImpl();

	@Override
	public void inserir(Bebe bebe) throws MaternidadeException {
		if (bebe.getGenitor1() != null || bebe.getGenitor2() != null)
			repository.inserir(bebe);
		else
			throw new MaternidadeException(
					"O beb� deve ter no m�nimo uma e no m�ximo duas Pessoas F�sicas indicadas como pais");
	}

	@Override
	public void alterar(Bebe bebe) throws MaternidadeException {
		if (bebe.getGenitor1() != null || bebe.getGenitor2() != null)
			repository.alterar(bebe);
		else
			throw new MaternidadeException(
					"O beb� deve ter no m�nimo uma e no m�ximo duas Pessoas F�sicas indicadas como pais");
	}

	@Override
	public void apagar(Bebe bebe) {
		repository.apagar(bebe);
	}

	@Override
	public Bebe buscarPorId(Integer id) throws MaternidadeException {
		Bebe busca = repository.buscarPorId(id);
		if (busca == null) {
			throw new MaternidadeException("Nenhum bebê foi encontrado com esta id");
		}
		return busca;
	}

	@Override
	public List<Bebe> listar() throws MaternidadeException {
		List<Bebe> busca = repository.listar();
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException("Não há bebê cadastrado");
		}
		return busca;
	}

	@Override
	public List<Bebe> listarPorPeriodo(Date dataInicial, Date dataFinal) throws MaternidadeException {
		List<Bebe> busca = repository.listarPorPeriodo(dataInicial, dataFinal);
		if (busca  == null || busca.size() == 0) {
			throw new MaternidadeException("Não há registos de bebê para este critério de busca");
		}
		return busca;
	}

}

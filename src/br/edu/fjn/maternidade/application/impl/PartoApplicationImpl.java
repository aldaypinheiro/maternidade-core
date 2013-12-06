package br.edu.fjn.maternidade.application.impl;

import java.util.Calendar;
import java.util.List;

import br.edu.fjn.maternidade.application.PartoApplication;
import br.edu.fjn.maternidade.domain.parto.Parto;
import br.edu.fjn.maternidade.domain.parto.PartoRepository;
import br.edu.fjn.maternidade.domain.parto.TipoParto;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.PartoRepositoryImpl;

public class PartoApplicationImpl implements PartoApplication {

	private PartoRepository repository = new PartoRepositoryImpl();

	@Override
	public void inserir(Parto parto) {
		repository.inserir(parto);
	}

	@Override
	public void alterar(Parto parto) {
		repository.alterar(parto);
	}

	@Override
	public void apagar(Parto parto) {
		repository.apagar(parto);
	}

	@Override
	public Parto buscarPorId(Integer id) throws MaternidadeException {
		Parto busca = repository.buscarPorId(id);

		if (busca == null) {
			throw new MaternidadeException(
					"Não há registro de parto com esta id");
		}

		return busca;
	}

	@Override
	public List<Parto> listar() throws MaternidadeException {
		List<Parto> busca = repository.listar();

		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException(
					"Não hpa registros de partos cadastrados");
		}

		return busca;
	}

	@Override
	public Integer quantidadePartosDiaro(Calendar data) throws MaternidadeException {
		Integer busca = repository.quantidadePartosDiaro(data);

		if (busca == null || busca == 0) {
			throw new MaternidadeException(
					"Não há registros de partos para o dia informado");
		}

		return busca;
	}

	@Override
	public Integer quantidadePartosMensal(Calendar dataInicial, Calendar dataFinal)
			throws MaternidadeException {
		Integer busca = repository.quantidadePartosMensal(dataInicial,
				dataFinal);

		if (busca == null || busca == 0) {
			throw new MaternidadeException(
					"Não há registros de partos para o mês informado");
		}

		return busca;
	}

	@Override
	public Integer quantidadePartosDiaroPorTipo(Calendar data, TipoParto tipoParto)
			throws MaternidadeException {
		Integer busca = repository
				.quantidadePartosDiaroPorTipo(data, tipoParto);

		if (busca == null || busca == 0) {
			throw new MaternidadeException(
					"Não há registros de partos para o dia e tipo informados");
		}

		return busca;
	}

	@Override
	public Integer quantidadePartosMensalPorTipo(Calendar dataInicial,
			Calendar dataFinal, TipoParto tipoParto) throws MaternidadeException {
		Integer busca = repository.quantidadePartosMensalPorTipo(dataInicial,
				dataFinal, tipoParto);

		if (busca == null || busca == 0) {
			throw new MaternidadeException(
					"Nã há registros de partos para o mês e tipo informados");
		}

		return busca;
	}

	@Override
	public List<Parto> buscarPartosPorDia(Calendar data) throws MaternidadeException {
		List<Parto> busca = repository.buscarPartosPorDia(data);
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException(
					"Não há registros de partos com os critérios de busca estabelecidos");
		}
		
		return busca;
	}

	@Override
	public List<Parto> buscarPartosPorMes(Calendar dataInicial, Calendar dataFinal) throws MaternidadeException {
		List<Parto> busca = repository.buscarPartosPorMes(dataInicial, dataFinal);
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException(
					"Não há registros de partos com os critérios de busca estabelecidos");
		}
		
		return busca;
	}

	@Override
	public List<Parto> buscarPartosPorDiaETipo(Calendar data, TipoParto tipoParto) throws MaternidadeException {
		List<Parto> busca = repository.buscarPartosPorDiaETipo(data, tipoParto);
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException(
					"Não há registros de partos com os critérios de busca estabelecidos");
		}
		
		return busca;
	}

	@Override
	public List<Parto> buscarPartosPorMesETipo(Calendar dataInicial,
			Calendar dataFinal, TipoParto tipoParto) throws MaternidadeException {
		List<Parto> busca = repository.buscarPartosPorMesETipo(dataInicial, dataFinal, tipoParto);
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException(
					"Não há registros de partos com os critérios de busca estabelecidos");
		}
		
		return busca;
	}

}

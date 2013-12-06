package br.edu.fjn.maternidade.domain.parto;

import java.util.Calendar;
import java.util.List;

import br.edu.fjn.maternidade.repository.AbstractRepository;

public interface PartoRepository extends AbstractRepository<Parto, Integer> {

	Integer quantidadePartosDiaro(Calendar data);

	Integer quantidadePartosMensal(Calendar dataInicial, Calendar dataFinal);

	Integer quantidadePartosDiaroPorTipo(Calendar data, TipoParto tipoParto);

	Integer quantidadePartosMensalPorTipo(Calendar dataInicial, Calendar dataFinal,
			TipoParto tipoParto);
	
	List<Parto> buscarPartosPorDia(Calendar data);

	List<Parto> buscarPartosPorMes(Calendar dataInicial, Calendar dataFinal);

	List<Parto> buscarPartosPorDiaETipo(Calendar data, TipoParto tipoParto);

	List<Parto> buscarPartosPorMesETipo(Calendar dataInicial, Calendar dataFinal,
			TipoParto tipoParto);

}

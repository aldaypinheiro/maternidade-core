package br.edu.fjn.maternidade.application;

import java.util.Calendar;
import java.util.List;

import br.edu.fjn.maternidade.domain.parto.Parto;
import br.edu.fjn.maternidade.domain.parto.TipoParto;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface PartoApplication {
	
	void inserir(Parto parto);

	void alterar(Parto parto);

	void apagar(Parto parto);
	
	Parto buscarPorId(Integer id) throws MaternidadeException;
	
	List<Parto> listar() throws MaternidadeException;
	
	Integer quantidadePartosDiaro(Calendar data) throws MaternidadeException;

	Integer quantidadePartosMensal(Calendar dataInicial, Calendar dataFinal) throws MaternidadeException;

	Integer quantidadePartosDiaroPorTipo(Calendar data, TipoParto tipoParto) throws MaternidadeException;

	Integer quantidadePartosMensalPorTipo(Calendar dataInicial, Calendar dataFinal, TipoParto tipoParto) throws MaternidadeException;
	
	List<Parto> buscarPartosPorDia(Calendar data) throws MaternidadeException;

	List<Parto> buscarPartosPorMes(Calendar dataInicial, Calendar dataFinal) throws MaternidadeException;

	List<Parto> buscarPartosPorDiaETipo(Calendar data, TipoParto tipoParto) throws MaternidadeException;

	List<Parto> buscarPartosPorMesETipo(Calendar dataInicial, Calendar dataFinal,
			TipoParto tipoParto) throws MaternidadeException;
}

package br.edu.fjn.maternidade.application;

import java.sql.Date;
import java.util.List;

import br.edu.fjn.maternidade.domain.bebe.Bebe;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface BebeApplication {
	
	void inserir(Bebe bebe) throws MaternidadeException;

	void alterar(Bebe bebe) throws MaternidadeException;

	void apagar(Bebe bebe);
	
	Bebe buscarPorId(Integer id) throws MaternidadeException;
	
	List<Bebe> listar() throws MaternidadeException;
	
	List<Bebe> listarPorPeriodo(Date dataInicial, Date dataFinal) throws MaternidadeException;
	
}

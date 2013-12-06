package br.edu.fjn.maternidade.application;

import java.util.List;

import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface EspecialidadeApplication {

	void inserir(Especialidade especialidade);

	void alterar(Especialidade especialidade);

	void apagar(Especialidade especialidade);
	
	Especialidade buscarPorId(Integer id) throws MaternidadeException;
	
	List<Especialidade> listar() throws MaternidadeException;
	
}

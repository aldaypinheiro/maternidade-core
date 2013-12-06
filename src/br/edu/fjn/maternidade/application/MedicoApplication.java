package br.edu.fjn.maternidade.application;

import java.util.List;

import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.domain.medico.Medico;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface MedicoApplication {

	void inserir(Medico medico) throws MaternidadeException;

	void alterar(Medico medico) throws MaternidadeException;

	void apagar(Medico medico);
	
	Medico buscarPorId(Integer id) throws MaternidadeException;
	
	List<Medico> listar() throws MaternidadeException;
	
	List<Medico> buscarMedicosPorEspecialidade(Especialidade especialidade) throws MaternidadeException;
	
	Integer quantidadeMedicosPorEspecialidade(Especialidade especialidade) throws MaternidadeException;
	
}

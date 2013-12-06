package br.edu.fjn.maternidade.application;

import java.util.List;

import br.edu.fjn.maternidade.domain.enfermeiro.Enfermeiro;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface EnfermeiroApplication {

	void inserir(Enfermeiro enfermeiro);

	void alterar(Enfermeiro enfermeiro);

	void apagar(Enfermeiro enfermeiro);
	
	Enfermeiro buscarPorId(Integer id) throws MaternidadeException;
	
	List<Enfermeiro> listar() throws MaternidadeException;
	
}

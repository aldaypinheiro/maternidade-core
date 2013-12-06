package br.edu.fjn.maternidade.application;

import java.util.List;

import br.edu.fjn.maternidade.domain.diretor.Diretor;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface DiretorApplication {

	void inserir(Diretor diretor);

	void alterar(Diretor diretor);

	void apagar(Diretor diretor) throws MaternidadeException;

	Diretor buscarPorId(Integer id) throws MaternidadeException;

	List<Diretor> listar() throws MaternidadeException;
	
	Diretor buscarPorUsuario(Usuario usuario) throws MaternidadeException;

}

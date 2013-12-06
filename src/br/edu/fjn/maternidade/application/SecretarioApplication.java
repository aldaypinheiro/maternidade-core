package br.edu.fjn.maternidade.application;

import java.util.List;

import br.edu.fjn.maternidade.domain.secretario.Secretario;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface SecretarioApplication {

	void inserir(Secretario secretario);

	void alterar(Secretario secretario);

	void apagar(Secretario secretario) throws MaternidadeException;
	
	Secretario buscarPorId(Integer id) throws MaternidadeException;
	
	List<Secretario> listar() throws MaternidadeException;

	Secretario buscarPorUsuario(Usuario usuario) throws MaternidadeException;
}

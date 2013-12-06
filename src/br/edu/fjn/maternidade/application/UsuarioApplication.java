package br.edu.fjn.maternidade.application;

import br.edu.fjn.maternidade.domain.hospital.Funcionario;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface UsuarioApplication {

	void inserir(Usuario usuario) throws MaternidadeException;

	void alterar(Usuario usuario);

	void apagar(Usuario usuario) throws MaternidadeException;
	
	Usuario buscarPorId(Integer id) throws MaternidadeException;
	
	Usuario buscarPorUsuario(String usuario) throws MaternidadeException;
	
	Usuario buscarPorUsuarioESenha(String usuario, String senha) throws MaternidadeException;

	Funcionario buscarFuncionarioPorUsuario(Usuario usuario) throws MaternidadeException;
	
}

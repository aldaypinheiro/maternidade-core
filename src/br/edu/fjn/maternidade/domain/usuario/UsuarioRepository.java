package br.edu.fjn.maternidade.domain.usuario;

import br.edu.fjn.maternidade.domain.hospital.Funcionario;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.AbstractRepository;

public interface UsuarioRepository extends AbstractRepository<Usuario, Integer> {

	Usuario buscarPorUsuario(String usuario);

	Usuario buscarPorUsuarioESenha(String usuario, String senha);

	Funcionario buscarFuncionarioPorUsuario(Usuario usuario) throws MaternidadeException;
	
}

package br.edu.fjn.maternidade.domain.secretario;

import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.repository.AbstractRepository;

public interface SecretarioRepository extends
		AbstractRepository<Secretario, Integer> {

	Secretario buscarPorUsuario(Usuario usuario);
	
}

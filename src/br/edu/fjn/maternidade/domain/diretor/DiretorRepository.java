package br.edu.fjn.maternidade.domain.diretor;

import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.repository.AbstractRepository;

public interface DiretorRepository extends AbstractRepository<Diretor, Integer> {

	Diretor buscarPorUsuario(Usuario usuario);
	
}

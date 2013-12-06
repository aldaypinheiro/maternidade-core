package br.edu.fjn.maternidade.repository;

import java.io.Serializable;
import java.util.List;

import br.edu.fjn.maternidade.domain.EntidadeMaternidade;

public interface AbstractRepository<T extends EntidadeMaternidade<Integer>, E extends Serializable> {

	void inserir(T entidade);

	void alterar(T entidade);

	void apagar(T entidade);

	T buscarPorId(E id);

	List<T> listar();

}

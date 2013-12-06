package br.edu.fjn.maternidade.domain.endereco;

import java.util.List;

import br.edu.fjn.maternidade.repository.AbstractRepository;

public interface EnderecoRepository extends
		AbstractRepository<Endereco, Integer> {

	List<Estado> listarEstados();

	List<Cidade> listarCidadePorEstado(Estado estado);

	Estado buscarEstadoPorId(Integer id);
	
	Cidade buscarCidadePorId(Integer id);
	
}

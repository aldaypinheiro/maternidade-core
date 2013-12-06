package br.edu.fjn.maternidade.application;

import java.util.List;

import br.edu.fjn.maternidade.domain.endereco.Cidade;
import br.edu.fjn.maternidade.domain.endereco.Endereco;
import br.edu.fjn.maternidade.domain.endereco.Estado;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public interface EnderecoApplication {

	void inserir(Endereco endereco);

	void alterar(Endereco endereco);

	void apagar(Endereco endereco);

	Endereco buscarPorId(Integer id) throws MaternidadeException;

	List<Estado> listarEstados();

	List<Cidade> listarCidadePorEstado(Estado estado);

	Estado buscarEstadoPorId(Integer id);

	Cidade buscarCidadePorId(Integer id);

}

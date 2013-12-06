package br.edu.fjn.maternidade.application.impl;

import java.util.List;

import br.edu.fjn.maternidade.application.EnderecoApplication;
import br.edu.fjn.maternidade.domain.endereco.Cidade;
import br.edu.fjn.maternidade.domain.endereco.Endereco;
import br.edu.fjn.maternidade.domain.endereco.EnderecoRepository;
import br.edu.fjn.maternidade.domain.endereco.Estado;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.EnderecoRepositoryImpl;

public class EnderecoApplicationImpl implements EnderecoApplication {

	private EnderecoRepository repository = new EnderecoRepositoryImpl();

	@Override
	public void inserir(Endereco endereco) {
		repository.inserir(endereco);
	}

	@Override
	public void alterar(Endereco endereco) {
		repository.alterar(endereco);
	}

	@Override
	public void apagar(Endereco endereco) {
		repository.apagar(endereco);
	}

	@Override
	public Endereco buscarPorId(Integer id) throws MaternidadeException {
		Endereco busca = repository.buscarPorId(id);
		
		if (busca == null) {
			throw new MaternidadeException("Não foi encontrado registro de endereço com esta id");
		}
		
		return busca;
	}


	@Override
	public List<Estado> listarEstados() {
		return repository.listarEstados();
	}

	@Override
	public List<Cidade> listarCidadePorEstado(Estado estado) {
		return repository.listarCidadePorEstado(estado);
	}

	@Override
	public Estado buscarEstadoPorId(Integer id) {
		return repository.buscarEstadoPorId(id);
	}

	@Override
	public Cidade buscarCidadePorId(Integer id) {
		return repository.buscarCidadePorId(id);
	}

}
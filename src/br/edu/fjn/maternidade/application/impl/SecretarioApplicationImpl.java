package br.edu.fjn.maternidade.application.impl;

import java.util.List;

import br.edu.fjn.maternidade.application.SecretarioApplication;
import br.edu.fjn.maternidade.domain.secretario.Secretario;
import br.edu.fjn.maternidade.domain.secretario.SecretarioRepository;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.SecretarioRepositoryImpl;

public class SecretarioApplicationImpl implements SecretarioApplication {

	private SecretarioRepository repository = new SecretarioRepositoryImpl();

	@Override
	public void inserir(Secretario secretario) {
		repository.inserir(secretario);
	}

	@Override
	public void alterar(Secretario secretario) {
		repository.alterar(secretario);
	}

	@Override
	public void apagar(Secretario secretario) throws MaternidadeException {
		if (repository.listar() != null)
			repository.apagar(secretario);
		else
			throw new MaternidadeException(
					"Voc� n�o pode remover este secret�rio, pois n�o existem outros cadastrados!");
	}

	@Override
	public Secretario buscarPorId(Integer id) throws MaternidadeException {
		Secretario busca = repository.buscarPorId(id);
		
		if (busca == null) {
			throw new MaternidadeException("Não há registro de secretário para esta id");
		}
		
		return busca;
	}

	@Override
	public List<Secretario> listar() throws MaternidadeException {
		List<Secretario> busca = repository.listar();
		
		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException("Não há registros de secretários");
		}
		
		return busca;
	}

	@Override
	public Secretario buscarPorUsuario(Usuario usuario) throws MaternidadeException {
		Secretario busca = repository.buscarPorUsuario(usuario);
		
		if (busca == null) {
			throw new MaternidadeException("Não há registro de secretário para este usuário");
		}
		
		return busca;
	}

}

package br.edu.fjn.maternidade.application.impl;

import br.edu.fjn.maternidade.application.HospitalApplication;
import br.edu.fjn.maternidade.application.SecretarioApplication;
import br.edu.fjn.maternidade.application.UsuarioApplication;
import br.edu.fjn.maternidade.domain.hospital.Funcionario;
import br.edu.fjn.maternidade.domain.usuario.TipoUsuario;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.domain.usuario.UsuarioRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.UsuarioRepositoryImpl;

public class UsuarioApplicationImpl implements UsuarioApplication {

	private UsuarioRepository repository = new UsuarioRepositoryImpl();
	private HospitalApplication hospitalApplication = new HospitalApplicationImpl();
	private SecretarioApplication secretarioApplication = new SecretarioApplicationImpl();

	@Override
	public void inserir(Usuario usuario) throws MaternidadeException {
		if (repository.buscarPorUsuario(usuario.getUsuario()) == null) {
			repository.inserir(usuario);
		} else {
			throw new MaternidadeException("Usuário já existe!");
		}
	}

	@Override
	public void alterar(Usuario usuario) {
		repository.alterar(usuario);
	}

	@Override
	public void apagar(Usuario usuario) throws MaternidadeException {
		if (usuario.getTipoUsuario() == TipoUsuario.DIRETOR
				&& hospitalApplication.getHospital().getDiretor()
						.getIdUsuario() == usuario.getId())
			throw new MaternidadeException(
					"Este � o atual diretor do hospital! Voc� n�o pode apag�-lo.");
		else if (usuario.getTipoUsuario() == TipoUsuario.SECRETARIO
				&& secretarioApplication.listar() == null)
			throw new MaternidadeException(
					"Voc� n�o pode remover este secret�rio, pois n�o existem outros cadastrados!");
		else
			repository.apagar(usuario);
	}

	@Override
	public Usuario buscarPorId(Integer id) throws MaternidadeException {
		Usuario busca = repository.buscarPorId(id);

		if (busca == null) {
			throw new MaternidadeException(
					"Não há registro de usuário com esta id");
		}

		return busca;
	}

	@Override
	public Usuario buscarPorUsuario(String usuario) throws MaternidadeException {
		Usuario busca = repository.buscarPorUsuario(usuario);

		if (busca != null) {
			throw new MaternidadeException(
					"Já existe um usuário cadastrado com este nome de usuário");
		}

		return busca;
	}

	@Override
	public Usuario buscarPorUsuarioESenha(String usuario, String senha)
			throws MaternidadeException {
		Usuario busca = repository.buscarPorUsuarioESenha(usuario, senha);

		if (busca == null) {
			throw new MaternidadeException("Usuário ou senha errados");
		}

		return busca;
	}

	@Override
	public Funcionario buscarFuncionarioPorUsuario(Usuario usuario)
			throws MaternidadeException {
		Funcionario busca = repository.buscarFuncionarioPorUsuario(usuario);

		if (busca == null) {
			throw new MaternidadeException(
					"Não há registro de funcionário para este usuário");
		}

		return busca;
	}

}

package br.edu.fjn.maternidade.application.impl;

import java.util.List;

import br.edu.fjn.maternidade.application.DiretorApplication;
import br.edu.fjn.maternidade.application.HospitalApplication;
import br.edu.fjn.maternidade.domain.diretor.Diretor;
import br.edu.fjn.maternidade.domain.diretor.DiretorRepository;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.DiretorRepositoryImpl;

public class DiretorApplicationImpl implements DiretorApplication {

	private DiretorRepository repository = new DiretorRepositoryImpl();
	private HospitalApplication hospitalApplication = new HospitalApplicationImpl();

	@Override
	public void inserir(Diretor diretor) {
		repository.inserir(diretor);
	}

	@Override
	public void alterar(Diretor diretor) {
		repository.alterar(diretor);
	}

	@Override
	public void apagar(Diretor diretor) throws MaternidadeException {
		if (hospitalApplication.getHospital().getDiretor() != diretor)
			repository.apagar(diretor);
		else
			throw new MaternidadeException(
					"Este � o atual diretor do hospital! Voc� n�o pode apag�-lo.");
	}

	@Override
	public Diretor buscarPorId(Integer id) throws MaternidadeException {
		Diretor busca = repository.buscarPorId(id);
		if (busca == null) {
			throw new MaternidadeException(
					"Não foi encontrado diretor com esta id.");
		}
		return busca;
	}

	@Override
	public List<Diretor> listar() throws MaternidadeException {
		List<Diretor> busca = repository.listar();

		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException(
					"Não há registro de diretor cadastrado.");
		}

		return busca;
	}

	@Override
	public Diretor buscarPorUsuario(Usuario usuario)
			throws MaternidadeException {
		Diretor busca = repository.buscarPorUsuario(usuario);

		if (busca == null) {
			throw new MaternidadeException(
					"Não foi encontrado diretor com este usuário.");
		}

		return busca;
	}

}

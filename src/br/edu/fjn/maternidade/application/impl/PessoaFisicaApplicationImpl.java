package br.edu.fjn.maternidade.application.impl;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.edu.fjn.maternidade.application.PessoaFisicaApplication;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisicaRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.PessoaFisicaRepositoryImpl;

public class PessoaFisicaApplicationImpl implements PessoaFisicaApplication {

	private PessoaFisicaRepository repository = new PessoaFisicaRepositoryImpl();
	private CPFValidator cpfValidador = new CPFValidator(true);

	@Override
	public void inserir(PessoaFisica pessoaFisica) throws MaternidadeException {
		try {
			cpfValidador.assertValid(pessoaFisica.getCpf());
		} catch (InvalidStateException e) {
			throw new MaternidadeException("CPF Inv�lido!");
		}
		repository.inserir(pessoaFisica);
	}

	@Override
	public void alterar(PessoaFisica pessoaFisica) throws MaternidadeException {
		try {
			cpfValidador.assertValid(pessoaFisica.getCpf());
		} catch (InvalidStateException e) {
			throw new MaternidadeException("CPF Inv�lido!");
		}
		repository.alterar(pessoaFisica);
	}

	@Override
	public void apagar(PessoaFisica pessoaFisica) {
		repository.apagar(pessoaFisica);
	}

	@Override
	public PessoaFisica buscarPorId(Integer id) throws MaternidadeException {
		PessoaFisica busca = repository.buscarPorId(id);

		if (busca == null) {
			throw new MaternidadeException(
					"Não há registro de pessoa física com esta id");
		}

		return busca;
	}

}

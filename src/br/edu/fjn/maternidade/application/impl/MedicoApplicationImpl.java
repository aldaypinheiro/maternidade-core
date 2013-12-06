package br.edu.fjn.maternidade.application.impl;

import java.util.List;

import br.edu.fjn.maternidade.application.MedicoApplication;
import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.domain.medico.Medico;
import br.edu.fjn.maternidade.domain.medico.MedicoRepository;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;
import br.edu.fjn.maternidade.repository.impl.MedicoRepositoryImpl;

public class MedicoApplicationImpl implements MedicoApplication {

	private MedicoRepository repository = new MedicoRepositoryImpl();

	@Override
	public void inserir(Medico medico) throws MaternidadeException {
		if (medico.getPessoaFisica().getCelular() != null
				|| !medico.getPessoaFisica().getCelular().equals(""))
			repository.inserir(medico);
		else
			throw new MaternidadeException("Informe um telefone para o m�dico.");
	}

	@Override
	public void alterar(Medico medico) throws MaternidadeException {
		if (medico.getPessoaFisica().getCelular() != null
				|| !medico.getPessoaFisica().getCelular().equals(""))
			repository.alterar(medico);
		else
			throw new MaternidadeException("Informe um telefone para o m�dico.");
	}

	@Override
	public void apagar(Medico medico) {
		repository.apagar(medico);
	}

	@Override
	public Medico buscarPorId(Integer id) throws MaternidadeException {
		Medico busca = repository.buscarPorId(id);

		if (busca == null) {
			throw new MaternidadeException("Não há registro de médico cadastrado com esta id");
		}

		return busca;
	}

	@Override
	public List<Medico> listar() throws MaternidadeException {
		List<Medico> busca = repository.listar();

		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException("Não há registros de médicos cadastrados");
		}

		return busca;
	}

	@Override
	public Integer quantidadeMedicosPorEspecialidade(Especialidade especialidade)
			throws MaternidadeException {
		Integer busca = repository
				.quantidadeMedicosPorEspecialidade(especialidade);

		if (busca == null || busca == 0) {
			throw new MaternidadeException("Não há registros de médicos com esta especialidade");
		}

		return busca;
	}

	@Override
	public List<Medico> buscarMedicosPorEspecialidade(Especialidade especialidade) throws MaternidadeException {
		List<Medico> busca = repository.buscarMedicosPorEspecialidade(especialidade);

		if (busca == null || busca.size() == 0) {
			throw new MaternidadeException("Não há registros de médicos cadastrados com a especialidade "+especialidade.getNome());
		}

		return busca;
	}

}

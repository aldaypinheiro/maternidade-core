package br.edu.fjn.maternidade.domain.medico;

import java.util.List;

import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.repository.AbstractRepository;

public interface MedicoRepository extends AbstractRepository<Medico, Integer> {

	List<Medico> buscarMedicosPorEspecialidade(Especialidade especialidade);
	
	Integer quantidadeMedicosPorEspecialidade(Especialidade especialidade);

}

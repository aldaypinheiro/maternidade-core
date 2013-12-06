package br.edu.fjn.maternidade.domain.bebe;

import java.sql.Date;
import java.util.List;

import br.edu.fjn.maternidade.repository.AbstractRepository;

public interface BebeRepository extends AbstractRepository<Bebe, Integer> {

	List<Bebe> listarPorPeriodo(Date dataInicial, Date dataFinal);

}

package br.edu.fjn.maternidade.domain.hospital;

import br.edu.fjn.maternidade.domain.EntidadeMaternidade;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;

public interface Funcionario extends EntidadeMaternidade<Integer> {

	PessoaFisica getPessoaFisica();
	
	void setPessoaFisica(PessoaFisica pessoaFisica);
	
	Integer getIdUsuario();
	
	void setIdUsuario(Integer idUsuario);
}

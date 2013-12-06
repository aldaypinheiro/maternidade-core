package teste;

import java.util.Calendar;

import br.edu.fjn.maternidade.application.EnderecoApplication;
import br.edu.fjn.maternidade.application.EspecialidadeApplication;
import br.edu.fjn.maternidade.application.MedicoApplication;
import br.edu.fjn.maternidade.application.impl.EnderecoApplicationImpl;
import br.edu.fjn.maternidade.application.impl.EspecialidadeApplicationImpl;
import br.edu.fjn.maternidade.application.impl.MedicoApplicationImpl;
import br.edu.fjn.maternidade.domain.endereco.Cidade;
import br.edu.fjn.maternidade.domain.endereco.Endereco;
import br.edu.fjn.maternidade.domain.medico.Medico;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.domain.pessoafisica.Sexo;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public class MedicoTeste {

	public static void mainas(String[] args) {
		EnderecoApplication ea = new EnderecoApplicationImpl();
		MedicoApplication ma = new MedicoApplicationImpl();
		EspecialidadeApplication espa = new EspecialidadeApplicationImpl();

		Cidade cidade = ea.buscarCidadePorId(2307304);

		Endereco e1 = new Endereco("Rua Projetada A", "10", "63020-000",
				"Bairro Projetado", cidade);
		Endereco e2 = new Endereco("Rua Projetada B", "20", "63030-000",
				"Bairro Projetado", cidade);
		Endereco e3 = new Endereco("Rua Projetada C", "30", "63040-000",
				"Bairro Projetado", cidade);

		PessoaFisica p1 = new PessoaFisica("Medico 1", Calendar.getInstance(),
				"3667-9009", "043.336.651-67", Sexo.MASCULINO, e1);
		p1.setCelular("8866-7799");

		PessoaFisica p2 = new PessoaFisica("Medica 2", Calendar.getInstance(),
				"3667-9009", "043.336.651-67", Sexo.FEMININO, e2);
		p2.setCelular("8866-7799");

		PessoaFisica p3 = new PessoaFisica("Medica 3", Calendar.getInstance(),
				"3667-9009", "043.336.651-67", Sexo.FEMININO, e3);
		p3.setCelular("8866-7799");

		Medico m1 = new Medico("123", p1);
		try {
			m1.adicionaEspecialidade(espa.buscarPorId(2));
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}
		
		Medico m2 = new Medico("456", p2);
		try {
			m2.adicionaEspecialidade(espa.buscarPorId(1));
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}
		
		Medico m3 = new Medico("789", p3);
		try {
			m3.adicionaEspecialidade(espa.buscarPorId(3));
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}
		
		try {
			ma.inserir(m1);
			ma.inserir(m2);
			ma.inserir(m3);
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}
		
	}
}

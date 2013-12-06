package teste;

import java.util.Calendar;

import br.edu.fjn.maternidade.application.EnderecoApplication;
import br.edu.fjn.maternidade.application.EnfermeiroApplication;
import br.edu.fjn.maternidade.application.EspecialidadeApplication;
import br.edu.fjn.maternidade.application.impl.EnderecoApplicationImpl;
import br.edu.fjn.maternidade.application.impl.EnfermeiroApplicationImpl;
import br.edu.fjn.maternidade.application.impl.EspecialidadeApplicationImpl;
import br.edu.fjn.maternidade.domain.endereco.Cidade;
import br.edu.fjn.maternidade.domain.endereco.Endereco;
import br.edu.fjn.maternidade.domain.enfermeiro.Enfermeiro;
import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.domain.pessoafisica.Sexo;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public class EnfermeiroTeste {
	
	public static void mainas(String[] args) {
		
		EnfermeiroApplication enfapp = new EnfermeiroApplicationImpl();
		EnderecoApplication endapp = new EnderecoApplicationImpl();
		EspecialidadeApplication espapp = new EspecialidadeApplicationImpl();
		
		Cidade cidade = endapp.buscarCidadePorId(2307304);
		
		Endereco e1 = new Endereco("Rua 123", "88", "63040-000", "Cidade Universitária", cidade);
		Endereco e2 = new Endereco("Rua Aridosvaldo", "15", "63059-123", "Vila Nova", cidade);
		Endereco e3 = new Endereco("Rua da Silva", "190", "63069-456", "Novo Aeroporto", cidade);
		
		PessoaFisica p1 = new PessoaFisica("Zezim", Calendar.getInstance(), "3535-9090", "305.222.211-22", Sexo.MASCULINO, e1);
		PessoaFisica p2 = new PessoaFisica("Maria", Calendar.getInstance(), "2101-3032", "427.759.552-90", Sexo.FEMININO, e2);
		PessoaFisica p3 = new PessoaFisica("Josefa", Calendar.getInstance(), "3243-7989", "657.563.155-00", Sexo.FEMININO, e3);
		
		Enfermeiro en1 = new Enfermeiro(p1);
		Enfermeiro en2 = new Enfermeiro(p2);
		Enfermeiro en3 = new Enfermeiro(p3);
		
		try {
			for (Especialidade especialidade : espapp.listar()) {
				en1.adicionaEspecialidade(especialidade);
			}
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}
		
		enfapp.inserir(en1);
		enfapp.inserir(en2);
		enfapp.inserir(en3);
	}
	
}

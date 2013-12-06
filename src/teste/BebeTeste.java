package teste;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import br.edu.fjn.maternidade.application.BebeApplication;
import br.edu.fjn.maternidade.application.EnderecoApplication;
import br.edu.fjn.maternidade.application.EnfermeiroApplication;
import br.edu.fjn.maternidade.application.MedicoApplication;
import br.edu.fjn.maternidade.application.impl.BebeApplicationImpl;
import br.edu.fjn.maternidade.application.impl.EnderecoApplicationImpl;
import br.edu.fjn.maternidade.application.impl.EnfermeiroApplicationImpl;
import br.edu.fjn.maternidade.application.impl.MedicoApplicationImpl;
import br.edu.fjn.maternidade.domain.bebe.Bebe;
import br.edu.fjn.maternidade.domain.endereco.Cidade;
import br.edu.fjn.maternidade.domain.endereco.Endereco;
import br.edu.fjn.maternidade.domain.enfermeiro.Enfermeiro;
import br.edu.fjn.maternidade.domain.equipemedica.EquipeMedica;
import br.edu.fjn.maternidade.domain.medico.Medico;
import br.edu.fjn.maternidade.domain.parto.Parto;
import br.edu.fjn.maternidade.domain.parto.TipoParto;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.domain.pessoafisica.Sexo;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public class BebeTeste {

	@SuppressWarnings("deprecation")
	public static void mainas(String[] args) {
		BebeApplication bebeapp = new BebeApplicationImpl();
		EnderecoApplication endapp = new EnderecoApplicationImpl();
		MedicoApplication medapp = new MedicoApplicationImpl();
		EnfermeiroApplication enfapp = new EnfermeiroApplicationImpl();
		
		Cidade cidade = endapp.buscarCidadePorId(2307304);
		
		Endereco e1 = new Endereco("Avenida Harry Potter", "7987", "63089-023", "Aeroporto", cidade);
		Endereco e2 = new Endereco("Avenida Harry Potter", "7987", "63089-023", "Aeroporto", cidade);
		
		PessoaFisica p1 = new PessoaFisica("Mae", Calendar.getInstance(), "3571-3571", "861.716.287-27", Sexo.FEMININO, e1);
		PessoaFisica p2 = new PessoaFisica("Mae 2", Calendar.getInstance(), "3571-3571", "275.057.308-43", Sexo.FEMININO, e1);
		
		PessoaFisica p3 = new PessoaFisica("Mae", Calendar.getInstance(), "3571-3571", "861.716.287-27", Sexo.FEMININO, e2);
		PessoaFisica p4 = new PessoaFisica("Mae 2", Calendar.getInstance(), "3571-3571", "275.057.308-43", Sexo.FEMININO, e2);
		
		Medico m1 = null, m2 = null, m3 = null;
		
		try {
			m1 = medapp.buscarPorId(1);
			m2 = medapp.buscarPorId(2);
			m3 = medapp.buscarPorId(3);
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}
		
		Enfermeiro en1 = null, en2 = null, en3 = null;
		
		try {
			en1 = enfapp.buscarPorId(1);
			en2 = enfapp.buscarPorId(2);
			en3 = enfapp.buscarPorId(3);
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}

		Set<Medico> medicos = new HashSet<Medico>();
		medicos.add(m1);
		medicos.add(m2);
		medicos.add(m3);
		
		Set<Enfermeiro> enfermeiros = new HashSet<Enfermeiro>();
		enfermeiros.add(en1);
		enfermeiros.add(en2);
		enfermeiros.add(en3);
		
		EquipeMedica em1 = new EquipeMedica(enfermeiros, medicos);
		EquipeMedica em2 = new EquipeMedica(enfermeiros, medicos);
		
		Parto parto1 = new Parto(Calendar.getInstance(), new Date(2013, 11, 29, 14, 02, 45), em1, TipoParto.NORMAL);
		Parto parto2 = new Parto(Calendar.getInstance(), new Date(2013, 11, 29, 14, 12, 45), em2, TipoParto.NORMAL);
		
		Bebe bebe1 = new Bebe("João", Calendar.getInstance(), 1.345, 50, Sexo.MASCULINO, parto1, p1);
		bebe1.setGenitor2(p2);
		Bebe bebe2 = new Bebe("Maria", Calendar.getInstance(), 1.005, 45, Sexo.FEMININO, parto2, p3);
		bebe2.setGenitor2(p4);
		
		try {
			bebeapp.inserir(bebe1);
			bebeapp.inserir(bebe2);
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}
	
	}
	
}
package teste;

import java.util.List;

import br.edu.fjn.maternidade.application.BebeApplication;
import br.edu.fjn.maternidade.application.EnderecoApplication;
import br.edu.fjn.maternidade.application.impl.BebeApplicationImpl;
import br.edu.fjn.maternidade.application.impl.EnderecoApplicationImpl;
import br.edu.fjn.maternidade.domain.endereco.Estado;

public class DiretorTeste {

	@SuppressWarnings("unused")
	public static void mainas(String[] args) {
		EnderecoApplication enderecoApplication  = new EnderecoApplicationImpl();
		BebeApplication bebeApplication = new BebeApplicationImpl();
		
		List<Estado> estados = enderecoApplication.listarEstados();

		for (Estado estado : estados) {
			System.out.println(estado.getNome());
			System.out.println("-----------");
		}

		/*List<Bebe> bebes = null;

		try {
			bebes = bebeApplication.listar();
		} catch (MaternidadeException e) {
			e.printStackTrace();
		}

		System.out.println(bebes.size());
		for (Bebe bebe : bebes) {
			System.out.println(bebe.getNome());
			System.out.println("------------------");
		}*/
		
	}

}

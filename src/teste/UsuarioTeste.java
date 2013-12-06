package teste;

import br.edu.fjn.maternidade.application.UsuarioApplication;
import br.edu.fjn.maternidade.application.impl.UsuarioApplicationImpl;
import br.edu.fjn.maternidade.domain.usuario.TipoUsuario;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public class UsuarioTeste {

	@SuppressWarnings("unused")
	public static void mainas(String[] args) {
		UsuarioApplication ua = new UsuarioApplicationImpl();
		
		//Lembrar de construir construtores das classes com seus atributos obrigatórios
		Usuario u1 = new Usuario("alday", "alday@123", TipoUsuario.DIRETOR);
		Usuario u2 = new Usuario("tiago", "tiago@123", TipoUsuario.DIRETOR);
		Usuario u3 = new Usuario("bruna", "bruna@123", TipoUsuario.SECRETARIO);
		Usuario u4 = new Usuario("junior", "junior@123", TipoUsuario.SECRETARIO);
		Usuario u5 = new Usuario("sammya", "sammya@123", TipoUsuario.SECRETARIO);
		Usuario u6 = new Usuario("alday", "sammya@123", TipoUsuario.SECRETARIO);
		
		try {
			ua.inserir(u1);
			ua.inserir(u2);
		} catch (MaternidadeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*for (Usuario u : ua.listar()) {
			System.out.println(u.getUsuario());
		}*/
		
		/*System.out.println(ua.buscarPorUsuarioESenha("alday", "alday@123"));*/
		
		/*System.out.println(ua.buscarPorUsuario("junior").getSenha());*/
		
		/*u3 = ua.buscarPorId(3);
		u3.setSenha("brunagatinhamanhosa");
		ua.alterar(u3);*/
		
		/*u5 = ua.buscarPorId(5);
		ua.apagar(u5);
		System.out.println(ua.buscarPorId(5));*/
		
		
		/*System.out.println(ua.buscarPorId(1).getUsuario());
		System.out.println(ua.buscarPorId(2).getUsuario());
		System.out.println(ua.buscarPorId(3).getUsuario());		
		System.out.println(ua.buscarPorId(4).getUsuario());
		System.out.println(ua.buscarPorId(5).getUsuario());*/
		
		/*try {
			ua.inserir(u1);
			System.out.println("Deu certo 1");
		} catch (MaternidadeException e) {
			System.out.println("Deu pau 1");
			e.printStackTrace();
		}
		try {
			ua.inserir(u2);
			System.out.println("Deu certo 2");
		} catch (MaternidadeException e) {
			System.out.println("Deu pau 2");
			e.printStackTrace();
		}
		try {
			ua.inserir(u3);
			System.out.println("Deu certo 3");
		} catch (MaternidadeException e) {
			System.out.println("Deu pau 3");
			e.printStackTrace();
		}
		try {
			ua.inserir(u4);
			System.out.println("Deu certo 4");
		} catch (MaternidadeException e) {
			System.out.println("Deu pau 4");
			e.printStackTrace();
		}
		try {
			ua.inserir(u5);
			System.out.println("Deu certo 5");
		} catch (MaternidadeException e) {
			System.out.println("Deu pau 5");
			e.printStackTrace();
		}
		try {
			ua.inserir(u6);
			System.out.println("Deu certo 6");
		} catch (MaternidadeException e) {
			System.out.println("Deu pau 6");
			e.printStackTrace();
		}*/
		
	}
	
}

package teste;

import java.util.Calendar;

import br.edu.fjn.maternidade.application.DiretorApplication;
import br.edu.fjn.maternidade.application.EnderecoApplication;
import br.edu.fjn.maternidade.application.HospitalApplication;
import br.edu.fjn.maternidade.application.SecretarioApplication;
import br.edu.fjn.maternidade.application.UsuarioApplication;
import br.edu.fjn.maternidade.application.impl.DiretorApplicationImpl;
import br.edu.fjn.maternidade.application.impl.EnderecoApplicationImpl;
import br.edu.fjn.maternidade.application.impl.HospitalApplicationImpl;
import br.edu.fjn.maternidade.application.impl.SecretarioApplicationImpl;
import br.edu.fjn.maternidade.application.impl.UsuarioApplicationImpl;
import br.edu.fjn.maternidade.domain.diretor.Diretor;
import br.edu.fjn.maternidade.domain.endereco.Cidade;
import br.edu.fjn.maternidade.domain.endereco.Endereco;
import br.edu.fjn.maternidade.domain.hospital.Hospital;
import br.edu.fjn.maternidade.domain.hospital.HospitalRepository;
import br.edu.fjn.maternidade.domain.pessoafisica.PessoaFisica;
import br.edu.fjn.maternidade.domain.pessoafisica.Sexo;
import br.edu.fjn.maternidade.domain.secretario.Secretario;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.repository.impl.HospitalRepositoryImpl;

public class TesteInserir {
	public static void mainas(String[] args) {
		EnderecoApplication ea = new EnderecoApplicationImpl();
		SecretarioApplication sa = new SecretarioApplicationImpl();
		DiretorApplication da = new DiretorApplicationImpl();
		UsuarioApplication ua = new UsuarioApplicationImpl();
		HospitalApplication ha = new HospitalApplicationImpl();
		HospitalRepository hr = new HospitalRepositoryImpl();
		
		try {
			Cidade cidade = ea.buscarCidadePorId(2307304);
			
			System.out.println(cidade);
			
			System.out.println("cidade: " + cidade.getNome());
			System.out.println("estado: " + cidade.getEstado().getNome());
			
			Usuario usuarioDiretor = ua.buscarPorUsuario("a");
			
			Endereco enderecoDiretor = new Endereco("Avenida Aracaju", "400", "63050-600", "Romeirão", cidade);
			PessoaFisica pessoaDiretor = new PessoaFisica("José Alday", Calendar.getInstance(), "3571-3926", "057.636.043-00", Sexo.MASCULINO, enderecoDiretor);
			Diretor diretor = new Diretor(pessoaDiretor, usuarioDiretor.getId());
			
			//da.inserir(diretor);
			
			diretor = da.buscarPorId(1);
			
			Endereco enderecoHospital = new Endereco("Rua São Benedito", "243", "63020-3353", "São Miguel", cidade);
			Hospital hospital = new Hospital("Hospital São Lucas", "Hospital Maternidade Municipal São Lucas", "29.847.876/0001-50", "(88) 3587-3353", diretor, enderecoHospital);
			
			hr.inserir(hospital);
			
			hospital = ha.getHospital();
			
			Usuario usuarioSecretario = ua.buscarPorUsuario("tiago");
			Endereco enderecoSecretario = new Endereco("Rua do Limoeiro", "123", "63010-548", "Limoeiro", cidade);
			PessoaFisica pessoaSecretario = new PessoaFisica("Tiago Xavier", Calendar.getInstance(), "3571.3926", "057.636.043-00", Sexo.MASCULINO, enderecoSecretario);
			Secretario secretario = new Secretario(pessoaSecretario, usuarioSecretario.getId());
			
			sa.inserir(secretario);
			
			/*secretario = sa.buscarPorId(1);
			
			usuarioSecretario.setTipoUsuario(TipoUsuario.SECRETARIO);
			
			ua.alterar(usuarioSecretario);*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

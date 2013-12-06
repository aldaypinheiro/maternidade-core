package teste;

import br.edu.fjn.maternidade.application.impl.EspecialidadeApplicationImpl;
import br.edu.fjn.maternidade.domain.especialidade.Especialidade;

public class EspecialidadeTeste {

	public static void mainas(String[] args) {
		EspecialidadeApplicationImpl ea = new EspecialidadeApplicationImpl();
		
		Especialidade esp1 = new Especialidade("Obstetra", "Especialidade em acompanhar a gravidez e realizar os partos.");
		Especialidade esp2 = new Especialidade("Anestesista", "Especialidade em vigiar e manter equilibrado o organismo do paciente.");
		Especialidade esp3 = new Especialidade("Ginecologista", "Especialidade no sistema reprodutor feminino, útero, vagina e ovários.");
		
		ea.inserir(esp1);
		ea.inserir(esp2);
		ea.inserir(esp3);
	}
	
}


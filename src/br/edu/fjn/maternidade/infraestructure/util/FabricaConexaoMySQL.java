package br.edu.fjn.maternidade.infraestructure.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaConexaoMySQL {

	private static EntityManagerFactory fabrica;

	private FabricaConexaoMySQL() {

	}

	private static EntityManagerFactory getFabrica() {
		if (fabrica == null) {
			criarConexao();
		}
		return fabrica;
	}

	private static void criarConexao() {
		fabrica = Persistence.createEntityManagerFactory("unit-ms");
	}

	public static EntityManager getManager() {
		if (fabrica == null) {
			getFabrica();
		}
		return fabrica.createEntityManager();
	}

}

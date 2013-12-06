package br.edu.fjn.maternidade.infraestructure.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaConexaoPostgreSQL {

	private static EntityManagerFactory fabrica;

	private FabricaConexaoPostgreSQL() {

	}

	private static EntityManagerFactory getFabrica() {
		if (fabrica == null) {
			criarConexao();
		}
		return fabrica;
	}

	private static void criarConexao() {
		fabrica = Persistence.createEntityManagerFactory("unit-pg");
	}

	public static EntityManager getManager() {
		if (fabrica == null) {
			getFabrica();
		}
		return fabrica.createEntityManager();
	}

}

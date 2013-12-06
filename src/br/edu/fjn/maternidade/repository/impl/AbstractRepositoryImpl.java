package br.edu.fjn.maternidade.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.edu.fjn.maternidade.domain.EntidadeMaternidade;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoPostgreSQL;
import br.edu.fjn.maternidade.repository.AbstractRepository;

public abstract class AbstractRepositoryImpl<T extends EntidadeMaternidade<Integer>, E extends Serializable>
		implements AbstractRepository<T, E> {

	private Class<T> classePersistente;

	public AbstractRepositoryImpl(Class<T> classeEntidade) {
		classePersistente = classeEntidade;
	}

	public Class<T> getClassPersistente() {
		return classePersistente;
	}

	@Override
	public void inserir(T entidade) {
		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(entidade);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}

	@Override
	public void alterar(T entidade) {
		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.merge(entidade);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

	}

	@Override
	public void apagar(T entidade) {
		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			entidade = manager.merge(entidade);
			manager.remove(entidade);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public T buscarPorId(E id) {
		T resultado = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			resultado = manager.find(getClassPersistente(), id);
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		List<T> retorno = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());
			
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.addOrder(Order.asc("id"));
			
			retorno = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return retorno;
	}

}

package br.edu.fjn.maternidade.repository.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.maternidade.domain.parto.Parto;
import br.edu.fjn.maternidade.domain.parto.PartoRepository;
import br.edu.fjn.maternidade.domain.parto.TipoParto;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoPostgreSQL;

public class PartoRepositoryImpl extends AbstractRepositoryImpl<Parto, Integer>
		implements PartoRepository {

	public PartoRepositoryImpl() {
		super(Parto.class);

	}

	@Override
	public Integer quantidadePartosDiaro(Calendar data) {
		Integer quantidade = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			// Dúvida: nome do atributo ou nome da coluna?
			// Dúvida: é assim que faz para busca com data?
			criteria.add(Restrictions.eq("data", data));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.setProjection(Projections.rowCount());

			quantidade = (Integer) criteria.uniqueResult();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.clear();
		}

		return quantidade;
	}

	@Override
	public Integer quantidadePartosMensal(Calendar dataInicial, Calendar dataFinal) {
		Integer quantidade = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			// Dúvida: nome do atributo ou nome da coluna?
			criteria.add(Restrictions.between("data", dataInicial, dataFinal));
			criteria.setProjection(Projections.rowCount());
			quantidade = (Integer) criteria.uniqueResult();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return quantidade;
	}

	@Override
	public Integer quantidadePartosDiaroPorTipo(Calendar data, TipoParto tipoParto) {
		Integer quantidade = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			// Dúvida: nome do atributo ou nome da coluna?
			Criterion c1 = Restrictions.eq("data", data);
			// Dúvida: nome do atributo ou nome da coluna?
			Criterion c2 = Restrictions.eq("tipoParto", tipoParto);

			criteria.add(Restrictions.and(c1, c2));
			criteria.setProjection(Projections.rowCount());

			quantidade = (Integer) criteria.uniqueResult();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return quantidade;
	}

	@Override
	public Integer quantidadePartosMensalPorTipo(Calendar dataInicial,
			Calendar dataFinal, TipoParto tipoParto) {
		Integer quantidade = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();

			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			// Dúvida: nome do atributo ou nome da coluna?
			Criterion c1 = Restrictions.between("data", dataInicial, dataFinal);
			// Dúvida: nome do atributo ou nome da coluna?
			Criterion c2 = Restrictions.eq("tipoParto", tipoParto);

			criteria.add(Restrictions.and(c1, c2));
			criteria.setProjection(Projections.rowCount());

			quantidade = (Integer) criteria.uniqueResult();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return quantidade;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parto> buscarPartosPorDia(Calendar data) {
		List<Parto> partos = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.add(Restrictions.eq("data", data));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			partos = criteria.list();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.clear();
		}

		return partos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parto> buscarPartosPorMes(Calendar dataInicial, Calendar dataFinal) {
		List<Parto> partos = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.add(Restrictions.between("data", dataInicial, dataFinal));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			partos = criteria.list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return partos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parto> buscarPartosPorDiaETipo(Calendar data, TipoParto tipoParto) {
		List<Parto> partos = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			Criterion c1 = Restrictions.eq("data", data);
			Criterion c2 = Restrictions.eq("tipoParto", tipoParto);

			criteria.add(Restrictions.and(c1, c2));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			partos = criteria.list();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return partos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Parto> buscarPartosPorMesETipo(Calendar dataInicial,
			Calendar dataFinal, TipoParto tipoParto) {
		List<Parto> partos = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();

			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			Criterion c1 = Restrictions.between("data", dataInicial, dataFinal);
			Criterion c2 = Restrictions.eq("tipoParto", tipoParto);

			criteria.add(Restrictions.and(c1, c2));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			partos = criteria.list();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
		return partos;
	}

}

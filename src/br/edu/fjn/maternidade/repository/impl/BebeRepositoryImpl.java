package br.edu.fjn.maternidade.repository.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.maternidade.domain.bebe.Bebe;
import br.edu.fjn.maternidade.domain.bebe.BebeRepository;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoPostgreSQL;

public class BebeRepositoryImpl extends AbstractRepositoryImpl<Bebe, Integer>
		implements BebeRepository {

	public BebeRepositoryImpl() {
		super(Bebe.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bebe> listarPorPeriodo(Date dataInicial, Date dataFinal) {
		List<Bebe> bebes = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			// Dúvida: nome do atributo ou nome da coluna?
			criteria.add(Restrictions.between("data", dataInicial, dataFinal));
			bebes = criteria.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return bebes;
	}

}

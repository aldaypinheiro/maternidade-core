package br.edu.fjn.maternidade.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.maternidade.domain.especialidade.Especialidade;
import br.edu.fjn.maternidade.domain.medico.Medico;
import br.edu.fjn.maternidade.domain.medico.MedicoRepository;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoPostgreSQL;

public class MedicoRepositoryImpl extends
		AbstractRepositoryImpl<Medico, Integer> implements MedicoRepository {

	public MedicoRepositoryImpl() {
		super(Medico.class);

	}

	@Override
	public Integer quantidadeMedicosPorEspecialidade(Especialidade especialidade) {
		Integer quantidade = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			// Dúvida: está correto para busca em relacionamento 1 para muitos
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.createAlias("especialidades", "e");
			criteria.add(Restrictions.eq("e.id", especialidade.getId()));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
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
	public List<Medico> buscarMedicosPorEspecialidade(Especialidade especialidade) {
		List<Medico> medicos = null;
		
		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			// Dúvida: está correto para busca em relacionamento 1 para muitos
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.createAlias("especialidades", "e");
			criteria.add(Restrictions.eq("e.id", especialidade.getId()));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			medicos = criteria.list();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return medicos;
	}
}

package br.edu.fjn.maternidade.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.maternidade.domain.secretario.Secretario;
import br.edu.fjn.maternidade.domain.secretario.SecretarioRepository;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoPostgreSQL;

public class SecretarioRepositoryImpl extends
		AbstractRepositoryImpl<Secretario, Integer> implements
		SecretarioRepository {

	public SecretarioRepositoryImpl() {
		super(Secretario.class);
	}

	@Override
	public Secretario buscarPorUsuario(Usuario usuario) {
		Secretario secretario = null;
		
		Integer idUsuario = usuario.getId();
		
		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();

			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.add(Restrictions.eq("idUsuario", idUsuario));
			
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			secretario = (Secretario) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return secretario;
	}

}

package br.edu.fjn.maternidade.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.maternidade.domain.diretor.Diretor;
import br.edu.fjn.maternidade.domain.diretor.DiretorRepository;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoPostgreSQL;

public class DiretorRepositoryImpl extends
		AbstractRepositoryImpl<Diretor, Integer> implements DiretorRepository {

	public DiretorRepositoryImpl() {
		super(Diretor.class);
	}

	@Override
	public Diretor buscarPorUsuario(Usuario usuario) {
		Diretor diretor = null;
		
		Integer idUsuario = usuario.getId();
		
		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();

			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.add(Restrictions.eq("idUsuario", idUsuario));

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			diretor = (Diretor) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return diretor;
	}
	
	

}

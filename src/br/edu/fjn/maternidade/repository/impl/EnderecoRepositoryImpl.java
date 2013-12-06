package br.edu.fjn.maternidade.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.maternidade.domain.endereco.Cidade;
import br.edu.fjn.maternidade.domain.endereco.Endereco;
import br.edu.fjn.maternidade.domain.endereco.EnderecoRepository;
import br.edu.fjn.maternidade.domain.endereco.Estado;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoPostgreSQL;

public class EnderecoRepositoryImpl extends
		AbstractRepositoryImpl<Endereco, Integer> implements EnderecoRepository {

	public EnderecoRepositoryImpl() {
		super(Endereco.class);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listarEstados() {
		List<Estado> estados = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(Estado.class);

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			criteria.addOrder(Order.asc("nome"));
			
			estados = criteria.list();

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return estados;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listarCidadePorEstado(Estado estado) {
		List<Cidade> cidades = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(Cidade.class);

			criteria.add(Restrictions.eq("estado", estado));

			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			criteria.addOrder(Order.asc("nome"));
			
			cidades = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return cidades;
	}

	@Override
	public Estado buscarEstadoPorId(Integer id) {
		Estado estado = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			estado = manager.find(Estado.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return estado;
	}

	@Override
	public Cidade buscarCidadePorId(Integer id) {
		Cidade cidade = null;

		EntityManager manager = FabricaConexaoPostgreSQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			cidade = manager.find(Cidade.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return cidade;
	}

}

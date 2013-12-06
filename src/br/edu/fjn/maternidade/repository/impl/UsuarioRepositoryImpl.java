package br.edu.fjn.maternidade.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.edu.fjn.maternidade.application.DiretorApplication;
import br.edu.fjn.maternidade.application.SecretarioApplication;
import br.edu.fjn.maternidade.application.impl.DiretorApplicationImpl;
import br.edu.fjn.maternidade.application.impl.SecretarioApplicationImpl;
import br.edu.fjn.maternidade.domain.hospital.Funcionario;
import br.edu.fjn.maternidade.domain.usuario.TipoUsuario;
import br.edu.fjn.maternidade.domain.usuario.Usuario;
import br.edu.fjn.maternidade.domain.usuario.UsuarioRepository;
import br.edu.fjn.maternidade.infraestructure.util.FabricaConexaoMySQL;
import br.edu.fjn.maternidade.infraestructure.util.MaternidadeException;

public class UsuarioRepositoryImpl implements UsuarioRepository {

	private Class<Usuario> classePersistente;

	public UsuarioRepositoryImpl() {
		classePersistente = Usuario.class;
	}

	public Class<Usuario> getClassPersistente() {
		return classePersistente;
	}

	@Override
	public void inserir(Usuario usuario) {
		EntityManager manager = FabricaConexaoMySQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(usuario);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public void alterar(Usuario usuario) {
		EntityManager manager = FabricaConexaoMySQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.merge(usuario);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public void apagar(Usuario usuario) {
		EntityManager manager = FabricaConexaoMySQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			usuario = manager.merge(usuario);
			manager.remove(usuario);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		Usuario resultado = null;

		EntityManager manager = FabricaConexaoMySQL.getManager();
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
	public List<Usuario> listar() {

		List<Usuario> usuario = null;

		EntityManager manager = FabricaConexaoMySQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());
			
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			
			usuario = criteria.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return usuario;
	}

	@Override
	public Usuario buscarPorUsuario(String usuario) {
		Usuario buscar = null;

		EntityManager manager = FabricaConexaoMySQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			criteria.add(Restrictions.eq("usuario", usuario));
			buscar = (Usuario) criteria.uniqueResult();
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return buscar;
	}

	@Override
	public Usuario buscarPorUsuarioESenha(String usuario, String senha) {
		Usuario buscar = null;

		EntityManager manager = FabricaConexaoMySQL.getManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			Criteria criteria = ((Session) manager.getDelegate())
					.createCriteria(getClassPersistente());

			Criterion c1 = Restrictions.eq("usuario", usuario);
			Criterion c2 = Restrictions.eq("senha", senha);

			criteria.add(Restrictions.and(c1, c2));
			
			buscar = (Usuario) criteria.uniqueResult();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			manager.close();
		}

		return buscar;
	}

	@Override
	public Funcionario buscarFuncionarioPorUsuario(Usuario usuario) throws MaternidadeException {
		Funcionario buscar = null;

		DiretorApplication da = null;
		SecretarioApplication sa = null;
		
		if (usuario.getTipoUsuario() == TipoUsuario.DIRETOR) {
			da = new DiretorApplicationImpl();
			buscar = da.buscarPorUsuario(usuario);
		} else {
			sa = new SecretarioApplicationImpl();
			buscar = sa.buscarPorUsuario(usuario);
		}

		return buscar;
	}

}

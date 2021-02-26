package modelo.dao.administrador;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.administrador.Administrador;
import modelo.factory.conexao.ConexaoFactory;

public class AdministradorDAOImpl implements AdministradorDAO {

	private ConexaoFactory fabrica;

	public AdministradorDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirAdministrador(Administrador admin) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(admin);

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null)
				sessao.getTransaction().rollback();
		} finally {
			if (sessao != null)
				sessao.close();
		}
	}

	public void atualizarAdministrador(Administrador admin) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(admin);

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null)
				sessao.getTransaction().rollback();
		} finally {
			if (sessao != null)
				sessao.close();
		}
	}

	public void deletarAdministrador(Administrador admin) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(admin);

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null)
				sessao.getTransaction().rollback();
		} finally {
			if (sessao != null)
				sessao.close();
		}
	}

	public List<Administrador> recuperarAdministradores() {
		Session sessao = null;
		List<Administrador> administradores = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Administrador> criteria = construtor.createQuery(Administrador.class);
			Root<Administrador> raizAdministrador = criteria.from(Administrador.class);

			criteria.select(raizAdministrador);

			administradores = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null)
				sessao.getTransaction().rollback();
		} finally {
			if (sessao != null)
				sessao.close();
		}
		return administradores;
	}
	
	public Administrador recuperarAdministradorPeloId(Administrador admin) {
		Session sessao = null;
		Administrador adminRecuperado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Administrador> criteria = construtor.createQuery(Administrador.class);
			Root<Administrador> raizAdministrador = criteria.from(Administrador.class);

			criteria.select(raizAdministrador);
			criteria.where(construtor.equal(raizAdministrador.get("id"), admin.getId()));

			adminRecuperado = sessao.createQuery(criteria).getSingleResult();

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		return adminRecuperado;
	}
	
	public Administrador recuperarAdministradorPeloCpf(Administrador admin) {
		Session sessao = null;
		Administrador adminRecuperado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Administrador> criteria = construtor.createQuery(Administrador.class);
			Root<Administrador> raizAdministrador = criteria.from(Administrador.class);

			criteria.select(raizAdministrador);
			criteria.where(construtor.equal(raizAdministrador.get("cpf"), admin.getCpf()));

			adminRecuperado = sessao.createQuery(criteria).getSingleResult();

			sessao.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		return adminRecuperado;
	}
}
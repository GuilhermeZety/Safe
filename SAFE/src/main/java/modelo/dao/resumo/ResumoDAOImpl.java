package modelo.dao.resumo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.resumo.Resumo;
import modelo.factory.conexao.ConexaoFactory;

public class ResumoDAOImpl implements ResumoDAO {

	private ConexaoFactory fabrica;

	public ResumoDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	@Override
	public void inserirResumo(Resumo resumo) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(resumo);

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
	}

	@Override
	public void atualizarResumo(Resumo resumo) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(resumo);

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
	}

	@Override
	public void deletarResumo(Resumo resumo) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(resumo);

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
	}

	@Override
	public List<Resumo> recuperarResumos() {
		Session sessao = null;
		List<Resumo> resumos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Resumo> criteria = construtor.createQuery(Resumo.class);
			Root<Resumo> raizResumo = criteria.from(Resumo.class);

			criteria.select(raizResumo);

			resumos = sessao.createQuery(criteria).getResultList();

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
		return resumos;
	}

	@Override
	public Resumo recuperarResumoPeloId(Resumo resumo) {
		Session sessao = null;
		Resumo resumoRecuperado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Resumo> criteria = construtor.createQuery(Resumo.class);
			Root<Resumo> raizResumo = criteria.from(Resumo.class);

			criteria.select(raizResumo);
			criteria.where(construtor.equal(raizResumo.get("id"), resumo.getId()));

			resumoRecuperado = sessao.createQuery(criteria).getSingleResult();

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
		return resumoRecuperado;
	}
}

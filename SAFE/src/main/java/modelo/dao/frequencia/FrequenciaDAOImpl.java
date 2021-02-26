package modelo.dao.frequencia;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.frequencia.Frequencia;
import modelo.factory.conexao.ConexaoFactory;

public class FrequenciaDAOImpl implements FrequenciaDAO {

	private ConexaoFactory fabrica;

	public FrequenciaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	@Override
	public void inserirFrequencia(Frequencia frequencia) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(frequencia);

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
	public void atualizarFrequencia(Frequencia frequencia) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(frequencia);

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
	public void deletarFrequencia(Frequencia frequencia) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(frequencia);

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
	public List<Frequencia> recuperarFrequencias() {
		Session sessao = null;
		List<Frequencia> frequencias = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Frequencia> criteria = construtor.createQuery(Frequencia.class);
			Root<Frequencia> raizFrequencia = criteria.from(Frequencia.class);

			criteria.select(raizFrequencia);

			frequencias = sessao.createQuery(criteria).getResultList();

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
		return frequencias;
	}
	
	public Frequencia recuperarFrequenciaPeloId(Frequencia frequencia) {
		Session sessao = null;
		Frequencia frequenciaRecuperada = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Frequencia> criteria = construtor.createQuery(Frequencia.class);
			Root<Frequencia> raizFrequencia = criteria.from(Frequencia.class);

			criteria.select(raizFrequencia);
			criteria.where(construtor.equal(raizFrequencia.get("id"), frequencia.getId()));

			frequenciaRecuperada = sessao.createQuery(criteria).getSingleResult();

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
		return frequenciaRecuperada;
	}
}

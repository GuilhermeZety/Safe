package modelo.dao.turma;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.turma.Turma;
import modelo.factory.conexao.ConexaoFactory;

public class TurmaDAOImpl implements TurmaDAO {

	private ConexaoFactory fabrica;

	public TurmaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	@Override
	public void inserirTurma(Turma turma) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(turma);

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
	public void atualizarTurma(Turma turma) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(turma);

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
	public void deletarTurma(Turma turma) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(turma);

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
	public List<Turma> recuperarTurmas() {
		Session sessao = null;
		List<Turma> turmas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
			Root<Turma> raizTurma = criteria.from(Turma.class);

			criteria.select(raizTurma);

			turmas = sessao.createQuery(criteria).getResultList();

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
		return turmas;
	}
	
	public Turma recuperarTurmaPeloId(Turma turma) {
		Session sessao = null;
		Turma turmaRecuperado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Turma> criteria = construtor.createQuery(Turma.class);
			Root<Turma> raizTurma = criteria.from(Turma.class);

			criteria.select(raizTurma);
			criteria.where(construtor.equal(raizTurma.get("id"), turma.getId()));

			turmaRecuperado = sessao.createQuery(criteria).getSingleResult();

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
		return turmaRecuperado;
	}
}

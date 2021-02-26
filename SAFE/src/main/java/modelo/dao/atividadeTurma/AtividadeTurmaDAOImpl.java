package modelo.dao.atividadeTurma;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.factory.conexao.ConexaoFactory;

public class AtividadeTurmaDAOImpl implements AtividadeTurmaDAO {

	private ConexaoFactory fabrica;

	public AtividadeTurmaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	@Override
	public void inserirAtividadeTurma(AtividadeTurma atividade) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(atividade);

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
	public void atualizarAtividadeTurma(AtividadeTurma atividade) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(atividade);

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
	public void deletarAtividadeTurma(AtividadeTurma atividade) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(atividade);

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
	public List<AtividadeTurma> recuperarAtividadesTurma() {
		Session sessao = null;
		List<AtividadeTurma> atividades = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<AtividadeTurma> criteria = construtor.createQuery(AtividadeTurma.class);
			Root<AtividadeTurma> raizAtividade = criteria.from(AtividadeTurma.class);

			criteria.select(raizAtividade);

			atividades = sessao.createQuery(criteria).getResultList();

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
		return atividades;
	}

	@Override
	public AtividadeTurma recuperarAtividadeTurmaPeloId(AtividadeTurma atividade) {
		Session sessao = null;
		AtividadeTurma atividadeRecuperada = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<AtividadeTurma> criteria = construtor.createQuery(AtividadeTurma.class);
			Root<AtividadeTurma> raizAtividade = criteria.from(AtividadeTurma.class);

			criteria.select(raizAtividade);
			criteria.where(construtor.equal(raizAtividade.get("id"), atividade.getId()));

			atividadeRecuperada = sessao.createQuery(criteria).getSingleResult();

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
		return atividadeRecuperada;
	}
	
	@Override
	public AtividadeTurma recuperarAtividadeTurmaPeloNome(AtividadeTurma atividade) {
		Session sessao = null;
		AtividadeTurma atividadeRecuperada = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<AtividadeTurma> criteria = construtor.createQuery(AtividadeTurma.class);
			Root<AtividadeTurma> raizAtividade = criteria.from(AtividadeTurma.class);

			criteria.select(raizAtividade);
			criteria.where(construtor.equal(raizAtividade.get("nome_atividade"), atividade.getNome()));

			atividadeRecuperada = sessao.createQuery(criteria).getSingleResult();

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
		return atividadeRecuperada;
	}
}

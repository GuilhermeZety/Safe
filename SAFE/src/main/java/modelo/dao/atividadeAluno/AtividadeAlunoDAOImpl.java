package modelo.dao.atividadeAluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.atividadeAluno.AtividadeAluno;
import modelo.factory.conexao.ConexaoFactory;

public class AtividadeAlunoDAOImpl implements AtividadeAlunoDAO {

	private ConexaoFactory fabrica;

	public AtividadeAlunoDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	@Override
	public void inserirAtividadeAluno(AtividadeAluno atividade) {
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
	public void atualizarAtividadeAluno(AtividadeAluno atividade) {
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
	public void deletarAtividadeAluno(AtividadeAluno atividade) {
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
	public List<AtividadeAluno> recuperarAtividadesAluno() {
		Session sessao = null;
		List<AtividadeAluno> atividades = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<AtividadeAluno> criteria = construtor.createQuery(AtividadeAluno.class);
			Root<AtividadeAluno> raizAtividade = criteria.from(AtividadeAluno.class);

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
	public AtividadeAluno recuperarAtividadeAlunoPeloId(AtividadeAluno atividade) {
		Session sessao = null;
		AtividadeAluno atividadeRecuperada = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<AtividadeAluno> criteria = construtor.createQuery(AtividadeAluno.class);
			Root<AtividadeAluno> raizAtividade = criteria.from(AtividadeAluno.class);

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
}

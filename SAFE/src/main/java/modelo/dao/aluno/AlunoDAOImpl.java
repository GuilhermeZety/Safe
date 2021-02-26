package modelo.dao.aluno;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.aluno.Aluno;
import modelo.factory.conexao.ConexaoFactory;

public class AlunoDAOImpl implements AlunoDAO {

	private ConexaoFactory fabrica;

	public AlunoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirAluno(Aluno aluno) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(aluno);

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

	public void atualizarAluno(Aluno aluno) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(aluno);

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

	public void deletarAluno(Aluno aluno) {
		Session sessao = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(aluno);

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

	public List<Aluno> recuperarAlunos() {
		Session sessao = null;
		List<Aluno> alunos = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			criteria.select(raizAluno);

			alunos = sessao.createQuery(criteria).getResultList();

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
		return alunos;
	}

	public Aluno recuperarAlunoPeloId(Aluno aluno) {
		Session sessao = null;
		Aluno alunoRecuperado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			criteria.select(raizAluno);
			criteria.where(construtor.equal(raizAluno.get("id"), aluno.getId()));

			alunoRecuperado = sessao.createQuery(criteria).getSingleResult();

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
		return alunoRecuperado;
	}
	
	public Aluno recuperarAlunoPelaMatricula(Aluno aluno) {
		Session sessao = null;
		Aluno alunoRecuperado = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Aluno> criteria = construtor.createQuery(Aluno.class);
			Root<Aluno> raizAluno = criteria.from(Aluno.class);

			criteria.select(raizAluno);
			criteria.where(construtor.equal(raizAluno.get("matricula"), aluno.getMatricula()));

			alunoRecuperado = sessao.createQuery(criteria).getSingleResult();

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
		return alunoRecuperado;
	}
}

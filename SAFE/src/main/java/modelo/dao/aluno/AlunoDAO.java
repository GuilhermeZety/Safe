package modelo.dao.aluno;

import java.util.List;

import modelo.entidade.aluno.Aluno;

public interface AlunoDAO {
	
	void inserirAluno(Aluno aluno);
	
	void atualizarAluno(Aluno aluno);
	
	void deletarAluno(Aluno aluno);
	
	List<Aluno> recuperarAlunos();

	Aluno recuperarAlunoPeloId(Aluno aluno);
	
	Aluno recuperarAlunoPelaMatricula(Aluno aluno);
}

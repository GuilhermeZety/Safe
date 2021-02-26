package modelo.dao.professor;

import java.util.List;

import modelo.entidade.professor.Professor;

public interface ProfessorDAO {

	void inserirProfessor(Professor professor);
	
	void atualizarProfessor(Professor professor);
	
	void deletarProfessor(Professor professor);
	
	List<Professor> recuperarProfessores();
	
	Professor recuperarProfessorPeloCpf(Professor professor);
	
	Professor recuperarProfessorPeloId(Professor professor);
}

package modelo.dao.turma;

import java.util.List;

import modelo.entidade.turma.Turma;

public interface TurmaDAO {

	void inserirTurma(Turma turma);
	
	void atualizarTurma(Turma turma);
	
	void deletarTurma(Turma turma);
	
	List<Turma> recuperarTurmas();
	
	Turma recuperarTurmaPeloId(Turma turma);
}

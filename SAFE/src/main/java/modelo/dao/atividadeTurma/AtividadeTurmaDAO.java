package modelo.dao.atividadeTurma;

import java.util.List;

import modelo.entidade.atividadeTurma.AtividadeTurma;

public interface AtividadeTurmaDAO {

	void inserirAtividadeTurma(AtividadeTurma atividade);
	
	void atualizarAtividadeTurma(AtividadeTurma atividade);
	
	void deletarAtividadeTurma(AtividadeTurma atividade);
	
	List<AtividadeTurma> recuperarAtividadesTurma();
	
	AtividadeTurma recuperarAtividadeTurmaPeloId(AtividadeTurma atividade);
	
	AtividadeTurma recuperarAtividadeTurmaPeloNome(AtividadeTurma atividade);
}

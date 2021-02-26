package modelo.dao.atividadeAluno;

import java.util.List;

import modelo.entidade.atividadeAluno.AtividadeAluno;

public interface AtividadeAlunoDAO {

	void inserirAtividadeAluno(AtividadeAluno atividade);
	
	void atualizarAtividadeAluno(AtividadeAluno atividade);
	
	void deletarAtividadeAluno(AtividadeAluno atividade);
	
	List<AtividadeAluno> recuperarAtividadesAluno();
	
	AtividadeAluno recuperarAtividadeAlunoPeloId(AtividadeAluno atividade);
}

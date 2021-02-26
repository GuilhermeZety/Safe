package modelo.entidade.atividadeTurma;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import modelo.entidade.extraAtividade.ExtraAtividade;
import modelo.entidade.professor.Professor;
import modelo.entidade.turma.Turma;

@Entity
@Table(name = "atividade")
public class AtividadeTurma extends ExtraAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "data_entrega_atividade")
	private String dataEntrega;
	
	public AtividadeTurma() {}
	
	public AtividadeTurma(Long id) {
		super(id);
	}
	
	public AtividadeTurma(String dataPostagem) {
		super(dataPostagem);
	}
	
	public AtividadeTurma(Long id, String dataPostagem, String dataEntrega, String materia, String conteudo, String nome, Professor professor, List<Turma> turmas) {
		super(id, dataPostagem, materia, conteudo, nome, professor, turmas);
		setDataEntrega(dataEntrega);
	}
	
	public AtividadeTurma(String dataPostagem, String dataEntrega, String materia, String nome, String conteudo, Professor professor, List<Turma> turmas) {
		super(dataPostagem, materia, nome, conteudo, professor, turmas);
		setDataEntrega(dataEntrega);
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
}

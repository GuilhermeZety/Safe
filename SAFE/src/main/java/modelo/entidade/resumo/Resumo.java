package modelo.entidade.resumo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import modelo.entidade.extraAtividade.ExtraAtividade;
import modelo.entidade.professor.Professor;
import modelo.entidade.turma.Turma;

@Entity
@Table(name = "resumo")
public class Resumo extends ExtraAtividade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Resumo() {}
	
	public Resumo(Long id) {
		super(id);
	}

	public Resumo(Long id, String dataPostagem, String materia, String conteudo, String nome, Professor professor, List<Turma> turmas) {
		super(id, dataPostagem, materia, conteudo, nome, professor, turmas);
	}

	public Resumo(String dataPostagem, String materia, String nome, String conteudo, Professor professor, List<Turma> turmas) {
		super(dataPostagem, materia, nome, conteudo, professor, turmas);
	}
}

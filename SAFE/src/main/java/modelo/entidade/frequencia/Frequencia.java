package modelo.entidade.frequencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.entidade.aluno.Aluno;
import modelo.entidade.turma.Turma;
	
@Entity
@Table(name = "frequencia")
public class Frequencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_frequencia")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	@Column(name = "presenca", length = 30, nullable = false, unique = false)
	private String presenca;
	
	public Frequencia() {}
	
	public Frequencia(Long id, Aluno aluno, Turma turma , String presenca) {
		setId(id);
		setAluno(aluno);
		setTurma(turma);
		setPresenca(presenca);
	}
	
	public Frequencia(Aluno aluno, Turma turma, String presenca) {
		setAluno(aluno);
		setTurma(turma);
		setPresenca(presenca);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}
}
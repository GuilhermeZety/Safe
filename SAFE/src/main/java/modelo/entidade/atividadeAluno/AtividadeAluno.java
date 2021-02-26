package modelo.entidade.atividadeAluno;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "atividade_aluno")
public class AtividadeAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Long id;
	
	@Column(name = "data_entrega_atividade")
	private Date dataEntrega;
	
	@Column(name = "entregue_atividade")
	private boolean entregue;
	
	@Column(name = "corrigido_atividade")
	private boolean corrigido;
	
	@Column(name = "nota_atividade")
	private String nota;
	
	@Column(name = "conteudo_atividade")
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	public AtividadeAluno(Long id, Date dataEntrega, boolean entregue, boolean corrigido, String nota, String conteudo, Aluno aluno, Turma turma) {
		setId(id);
		setDataEntrega(dataEntrega);
		setEntregue(entregue);
		setCorrigido(corrigido);
		setNota(nota);
		setConteudo(conteudo);
		setAluno(aluno);
		setTurma(turma);
	}
	
	public AtividadeAluno(Date dataEntrega, boolean entregue, boolean corrigido, String nota, String conteudo, Aluno aluno, Turma turma) {
		setDataEntrega(dataEntrega);
		setEntregue(entregue);
		setCorrigido(corrigido);
		setNota(nota);
		setConteudo(conteudo);
		setAluno(aluno);
		setTurma(turma);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public boolean isCorrigido() {
		return corrigido;
	}

	public void setCorrigido(boolean corrigido) {
		this.corrigido = corrigido;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
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
}

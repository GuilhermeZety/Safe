package modelo.entidade.professor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.resumo.Resumo;
import modelo.entidade.turma.Turma;
import modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "professor")
public class Professor extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(mappedBy = "professores", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Turma> turmas = new ArrayList<Turma>();
	
	@OneToMany(mappedBy = "professor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<AtividadeTurma> atividades = new ArrayList<AtividadeTurma>();

	@OneToMany(mappedBy = "professor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Resumo> resumos = new ArrayList<Resumo>();
	
	public Professor() {}
	
	public Professor(Long id) {
		super(id);
	}
	
	public Professor(String cpf) {
		setCpf(cpf);
	}
	
	public Professor(Long id, String nome, String sobrenome, String cpf, String email, String senha, List<Turma> turmas) {
		super(nome, sobrenome, cpf, email, senha);
		setTurmas(turmas);
	}
	
	public Professor(String nome, String sobrenome, String cpf, String email, String senha, List<Turma> turmas) {
		super(nome, sobrenome, cpf, email, senha);
		setTurmas(turmas);
	}
	
	public void adicionarTurma(Turma turma) {
		turmas.add(turma);
	}
	
	public void adicionarAtividade(AtividadeTurma atividade) {
		atividades.add(atividade);
	}
	
	public void removerAtividade(AtividadeTurma atividade) {
		atividades.remove(atividade);
	}
	
	public void adicionarResumo(Resumo resumo) {
		resumos.add(resumo);
	}
	
	public void removerResumo(Resumo resumo) {
		resumos.remove(resumo);
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public void setTurmas(List<Turma> turma) {
		this.turmas = turma;
	}
	
	public List<AtividadeTurma> getAtividades() {
		return atividades;
	}
	
	public void setAtividades(List<AtividadeTurma> atividades) {
		this.atividades = atividades;
	}
	
	public List<Resumo> getResumos() {
		return resumos;
	}
	
	public void setResumos(List<Resumo> resumos) {
		this.resumos = resumos;
	}
}

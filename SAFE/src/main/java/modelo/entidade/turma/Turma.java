package modelo.entidade.turma;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import modelo.entidade.aluno.Aluno;
import modelo.entidade.atividadeAluno.AtividadeAluno;
import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.frequencia.Frequencia;
import modelo.entidade.professor.Professor;
import modelo.entidade.resumo.Resumo;
import modelo.enumeracao.TipoEnsino;

@Entity
@Table(name = "turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long id;
	
	@Column(name = "turma_serie", length = 1, nullable = false, unique = false)
	private String serie;
	
	@Column(name = "turma", length = 40, nullable = false, unique = false)
	private String turma;
	
	@Enumerated(EnumType.STRING)
	private TipoEnsino tipoEnsino;
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Frequencia> frequencias = new ArrayList<Frequencia>();
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Aluno> alunos;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinTable(name = "turma_professor", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns =  @JoinColumn(name = "id"))
	private List<Professor> professores = new ArrayList<Professor>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinTable(name = "turma_atividade", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns =  @JoinColumn(name = "atividade_id"))
	private List<AtividadeTurma> atividadesTurma = new ArrayList<AtividadeTurma>();
	
	@OneToMany(mappedBy = "turma", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<AtividadeAluno> atividadesAluno = new ArrayList<AtividadeAluno>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	@JoinTable(name = "turma_resumo", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns =  @JoinColumn(name = "resumo_id"))
	private List<Resumo> resumos = new ArrayList<Resumo>();
	
	public Turma() {}
	
	public Turma(Long id) {
		setId(id);
	}
	
	public Turma(Long id, String serie, String turma, TipoEnsino tipoEnsino, List<Aluno> alunos, List<Professor> professores) {
		setId(id);
		setSerie(serie);
		setTurma(turma);
		setTipoEnsino(tipoEnsino);
		setAlunos(alunos);
		setProfessores(professores);
	}
	
	public Turma(String serie, String turma, TipoEnsino tipoEnsino) {
		setSerie(serie);
		setTurma(turma);
		setTipoEnsino(tipoEnsino);
	}
	
	public void adicionarFrequencia(Frequencia frequencia) {
		frequencias.add(frequencia);
	}
	
	public void removerFrequencia(Frequencia frequencia) {
		frequencias.add(frequencia);
	}
	
	public void adicionarAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	
	public void adicionarProfessor(Professor professor) {
		professores.add(professor);
	}
	
	public void removerProfessor(Professor professor) {
		professores.remove(professor);
	}
	
	public void adicionarAtividadeTurma(AtividadeTurma atividadeTurma) {
		atividadesTurma.add(atividadeTurma);
	}	
	
	public void removerAtividadeTurma(AtividadeTurma atividadeTurma) {
		atividadesTurma.remove(atividadeTurma);
	}
	
	public void adicionarAtividadeAluno(AtividadeAluno atividadeAluno) {
		atividadesAluno.add(atividadeAluno);
	}
	
	public void removerAtividadeAluno(AtividadeAluno atividadeAluno) {
		atividadesAluno.remove(atividadeAluno);
	}
	
	public void adicionarResumo(Resumo resumo) {
		resumos.add(resumo);
	}	
	
	public void removerResumo(Resumo resumo) {
		resumos.remove(resumo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	public TipoEnsino getTipoEnsino() {
		return tipoEnsino;
	}
	
	public void setTipoEnsino(TipoEnsino tipoEnsino) {
		this.tipoEnsino = tipoEnsino;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public List<AtividadeTurma> getAtividadesTurma() {
		return atividadesTurma;
	}
	
	public void setAtividades(List<AtividadeTurma> atividadesTurma) {
		this.atividadesTurma = atividadesTurma;
	}
	
	public List<AtividadeAluno> getAtividadesAluno() {
		return atividadesAluno;
	}
	
	public void setAtividadesAluno(List<AtividadeAluno> atividadesAluno) {
		this.atividadesAluno = atividadesAluno;
	}
	
	public List<Resumo> getResumos() {
		return resumos;
	}
	
	public void setResumos(List<Resumo> resumos) {
		this.resumos = resumos;
	}
	
	@Override
	public String toString() {
		String seriaTurma = this.serie + "ª " + this.turma;
		if(tipoEnsino == TipoEnsino.ANOS_INICIAIS)
			return seriaTurma + " - " + "Anos Inicias";
		else if(tipoEnsino == TipoEnsino.ENSINO_FUNDAMENTAL)
			return seriaTurma + " - " + "Ensino Fundamental";
		else
			return seriaTurma + " - " + "Ensino Médio";
	}
}

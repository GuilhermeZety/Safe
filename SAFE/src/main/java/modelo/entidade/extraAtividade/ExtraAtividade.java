package modelo.entidade.extraAtividade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.entidade.professor.Professor;
import modelo.entidade.turma.Turma;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "extraAtividade")
public abstract class ExtraAtividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Long id;
	
	@Column(name = "data_postagem_atividade")
	private String dataPostagem;
	
	@Column(name = "materia_atividade", length = 40, nullable = false, unique = false)
	private String materia;
	
	@Column(name = "conteudo_atividade")
	private String conteudo;
	
	@Column(name = "nome_atividade")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public ExtraAtividade() {}
	
	public ExtraAtividade(Long id) {
		setId(id);
	}
	
	public ExtraAtividade(String nome) {
		setNome(nome);
	}
	
	public ExtraAtividade(Long id, String dataPostagem, String materia, String conteudo, String nome, Professor professor, List<Turma> turmas) {
		setId(id);
		setDataPostagem(dataPostagem);
		setMateria(materia);
		setProfessor(professor);
		setNome(nome);
		setTurmas(turmas);
	}
	
	public ExtraAtividade(String dataPostagem, String materia, String nome, String couteudo, Professor professor, List<Turma> turmas) {
		setDataPostagem(dataPostagem);
		setMateria(materia);
		setProfessor(professor);
		setNome(nome);
		setTurmas(turmas);
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(String dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	
	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}

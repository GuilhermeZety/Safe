package modelo.entidade.aluno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import modelo.entidade.atividadeAluno.AtividadeAluno;
import modelo.entidade.frequencia.Frequencia;
import modelo.entidade.turma.Turma;
import modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "aluno")
public class Aluno extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idade_aluno", length = 3, nullable = false, unique = false)
	private int idade;
	
	@Column(name = "matricula_aluno", length = 20, nullable = false, unique = true)
	private String matricula;

	@Column(name = "responsavel_aluno", length = 30, nullable = false, unique = false)
	private String nomeResponsavel;
	
	@OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<Frequencia> frequencias = new ArrayList<Frequencia>();
	
	@OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(org.hibernate.annotations.FetchMode.SUBSELECT)
	private List<AtividadeAluno> atividadesAluno = new ArrayList<AtividadeAluno>();
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	public Aluno() {}
	
	public Aluno(Long id) {
		super(id);
	}
	
	public Aluno(String matricula) {
		setMatricula(matricula);
	}
	
	public Aluno (Long id, String nome, String sobrenome, int idade, String cpf, String matricula, String nomeResponsavel ,String email, String senha, Turma turma) {
		super(id, nome, sobrenome,  cpf, email, senha);
		setIdade(idade);
		setMatricula(matricula);
		setNomeResponsavel(nomeResponsavel);
		setTurma(turma);
	}

	public Aluno(String nome, String sobrenome, int idade, String cpf, String matricula, String nomeResponsavel, String email, String senha, Turma turma) {
		super(nome, sobrenome, cpf, email, senha);
		setIdade(idade);
		setMatricula(matricula);
		setNomeResponsavel(nomeResponsavel);
		setTurma(turma);
	}
	
	public void adicionarFrequencia(Frequencia frequencia) {
		frequencias.add(frequencia);
	}
	
	public void removerFrequencia(Frequencia frequencia) {
		frequencias.add(frequencia);
	}
	
	public void adicionarAtividade(AtividadeAluno atividadeAluno) {
		atividadesAluno.add(atividadeAluno);
	}
	
	public void removerAtividade(AtividadeAluno atividadeAluno) {
		atividadesAluno.add(atividadeAluno);
	}
	
	public List<AtividadeAluno> getAtividadesAluno() {
		return atividadesAluno;
	}
	
	public void setAtividadesAluno(List<AtividadeAluno> atividadesAluno) {
		this.atividadesAluno = atividadesAluno;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
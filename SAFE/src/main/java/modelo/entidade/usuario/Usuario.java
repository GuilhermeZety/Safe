package modelo.entidade.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome", length = 40, nullable = false, unique = false)
	private String nome;
	
	@Column(name = "sobrenome", length = 40, nullable = false, unique = false)
	private String sobrenome;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "senha", length = 20, nullable = false, unique = false)
	private String senha;
	
	public Usuario() {}
	
	public Usuario(Long id) {
		setId(id);
	}
	
	public Usuario(Long id, String nome, String sobrenome, String cpf, String email, String senha) {
		setId(id);
		setNome(nome);
		setSobrenome(sobrenome);
		setCpf(cpf);
		setEmail(email);
		setSenha(senha);
	}
	
	public Usuario(String nome, String sobrenome, String cpf, String email, String senha) {
		setNome(nome);
		setSobrenome(sobrenome);
		setCpf(cpf);
		setEmail(email);
		setSenha(senha);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
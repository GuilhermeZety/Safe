package modelo.entidade.instituicao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import modelo.entidade.turma.Turma;
import modelo.enumeracao.Estado;

@Entity
@Table(name = "instituicao")
public class Instituicao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_instituicao")
	private Long id;
	
	@Column(name = "nome_instituicao", length = 40, nullable = false, unique = false)
	private String nome;
	
	@Column(name = "cnpj_instituicao", length = 18, nullable = false, unique = false)
	private String cnpj;
	
	@Column(name = "endereco_instituicao", length = 30, nullable = false, unique = false)
	private String endereco;
	
	@Column(name = "endereco2_instituicao", length = 30, nullable = false, unique = false)
	private String endereco2;
	
	@Column(name = "cidade_instituicao", length = 30, nullable = false, unique = false)
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_instituicao", length = 30, nullable = false, unique = false)
	private Estado estado;
	
	@Column(name = "cep_instituicao", nullable = false, unique = false)
	private String cep;
	
	public Instituicao() {}
	
	public Instituicao(Long id) {
		setId(id);
	}
	
	public Instituicao(String cnpj) {
		setCnpj(cnpj);
	}
	
	public Instituicao(Long id, String nome, String cnpj, String endereco, String endereco2, String cidade, Estado estado, String cep, List<Turma> turmas) {
		setId(id);
		setNome(nome);
		setCnpj(cnpj);
		setEndereco(endereco);
		setEndereco2(endereco2);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
	}
	
	public Instituicao(String nome, String cnpj, String endereco, String endereco2, String cidade, Estado estado, String cep) {
		setNome(nome);
		setCnpj(cnpj);
		setEndereco(endereco);
		setEndereco2(endereco2);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco2() {
		return endereco2;
	}

	public void setEndereco2(String endereco2) {
		this.endereco2 = endereco2;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}

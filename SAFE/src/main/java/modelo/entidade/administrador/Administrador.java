package modelo.entidade.administrador;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "administrador")
public class Administrador extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Administrador() {
		super();
	}
	
	public Administrador(Long id) {
		super(id);
	}
	
	public Administrador(String cpf) {
		setCpf(cpf);
	}
	
	public Administrador(Long id, String nome, String sobrenome, String cpf, String email, String senha) {
		super(id, nome, sobrenome, cpf, email, senha);
	}
	
	public Administrador(String nome, String sobrenome, String cpf, String email, String senha) {
		super(nome, sobrenome, cpf, email, senha);
	}
}

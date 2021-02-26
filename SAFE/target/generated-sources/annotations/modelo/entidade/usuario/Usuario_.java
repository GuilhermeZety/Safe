package modelo.entidade.usuario;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SingularAttribute<Usuario, String> cpf;
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, Long> id;
	public static volatile SingularAttribute<Usuario, String> sobrenome;
	public static volatile SingularAttribute<Usuario, String> email;

	public static final String SENHA = "senha";
	public static final String CPF = "cpf";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String SOBRENOME = "sobrenome";
	public static final String EMAIL = "email";

}


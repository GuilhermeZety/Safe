package modelo.entidade.instituicao;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.enumeracao.Estado;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Instituicao.class)
public abstract class Instituicao_ {

	public static volatile SingularAttribute<Instituicao, String> cidade;
	public static volatile SingularAttribute<Instituicao, Estado> estado;
	public static volatile SingularAttribute<Instituicao, String> endereco;
	public static volatile SingularAttribute<Instituicao, String> endereco2;
	public static volatile SingularAttribute<Instituicao, String> nome;
	public static volatile SingularAttribute<Instituicao, Long> id;
	public static volatile SingularAttribute<Instituicao, String> cnpj;
	public static volatile SingularAttribute<Instituicao, String> cep;

	public static final String CIDADE = "cidade";
	public static final String ESTADO = "estado";
	public static final String ENDERECO = "endereco";
	public static final String ENDERECO2 = "endereco2";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String CNPJ = "cnpj";
	public static final String CEP = "cep";

}


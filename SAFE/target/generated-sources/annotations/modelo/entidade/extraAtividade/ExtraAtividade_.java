package modelo.entidade.extraAtividade;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidade.professor.Professor;
import modelo.entidade.turma.Turma;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExtraAtividade.class)
public abstract class ExtraAtividade_ {

	public static volatile SingularAttribute<ExtraAtividade, String> conteudo;
	public static volatile SingularAttribute<ExtraAtividade, Professor> professor;
	public static volatile ListAttribute<ExtraAtividade, Turma> turmas;
	public static volatile SingularAttribute<ExtraAtividade, String> dataPostagem;
	public static volatile SingularAttribute<ExtraAtividade, String> materia;
	public static volatile SingularAttribute<ExtraAtividade, String> nome;
	public static volatile SingularAttribute<ExtraAtividade, Long> id;

	public static final String CONTEUDO = "conteudo";
	public static final String PROFESSOR = "professor";
	public static final String TURMAS = "turmas";
	public static final String DATA_POSTAGEM = "dataPostagem";
	public static final String MATERIA = "materia";
	public static final String NOME = "nome";
	public static final String ID = "id";

}


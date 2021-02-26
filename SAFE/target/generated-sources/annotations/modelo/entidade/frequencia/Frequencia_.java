package modelo.entidade.frequencia;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidade.aluno.Aluno;
import modelo.entidade.turma.Turma;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Frequencia.class)
public abstract class Frequencia_ {

	public static volatile SingularAttribute<Frequencia, String> presenca;
	public static volatile SingularAttribute<Frequencia, Aluno> aluno;
	public static volatile SingularAttribute<Frequencia, Long> id;
	public static volatile SingularAttribute<Frequencia, Turma> turma;

	public static final String PRESENCA = "presenca";
	public static final String ALUNO = "aluno";
	public static final String ID = "id";
	public static final String TURMA = "turma";

}


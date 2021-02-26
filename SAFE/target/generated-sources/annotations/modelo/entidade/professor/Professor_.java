package modelo.entidade.professor;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.resumo.Resumo;
import modelo.entidade.turma.Turma;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Professor.class)
public abstract class Professor_ extends modelo.entidade.usuario.Usuario_ {

	public static volatile ListAttribute<Professor, AtividadeTurma> atividades;
	public static volatile ListAttribute<Professor, Turma> turmas;
	public static volatile ListAttribute<Professor, Resumo> resumos;

	public static final String ATIVIDADES = "atividades";
	public static final String TURMAS = "turmas";
	public static final String RESUMOS = "resumos";

}


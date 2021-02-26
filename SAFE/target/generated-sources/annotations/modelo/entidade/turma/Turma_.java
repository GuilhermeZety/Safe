package modelo.entidade.turma;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidade.aluno.Aluno;
import modelo.entidade.atividadeAluno.AtividadeAluno;
import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.frequencia.Frequencia;
import modelo.entidade.professor.Professor;
import modelo.entidade.resumo.Resumo;
import modelo.enumeracao.TipoEnsino;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Turma.class)
public abstract class Turma_ {

	public static volatile ListAttribute<Turma, AtividadeAluno> atividadesAluno;
	public static volatile ListAttribute<Turma, AtividadeTurma> atividadesTurma;
	public static volatile SingularAttribute<Turma, TipoEnsino> tipoEnsino;
	public static volatile ListAttribute<Turma, Aluno> alunos;
	public static volatile ListAttribute<Turma, Resumo> resumos;
	public static volatile SingularAttribute<Turma, String> serie;
	public static volatile ListAttribute<Turma, Frequencia> frequencias;
	public static volatile SingularAttribute<Turma, Long> id;
	public static volatile SingularAttribute<Turma, String> turma;
	public static volatile ListAttribute<Turma, Professor> professores;

	public static final String ATIVIDADES_ALUNO = "atividadesAluno";
	public static final String ATIVIDADES_TURMA = "atividadesTurma";
	public static final String TIPO_ENSINO = "tipoEnsino";
	public static final String ALUNOS = "alunos";
	public static final String RESUMOS = "resumos";
	public static final String SERIE = "serie";
	public static final String FREQUENCIAS = "frequencias";
	public static final String ID = "id";
	public static final String TURMA = "turma";
	public static final String PROFESSORES = "professores";

}


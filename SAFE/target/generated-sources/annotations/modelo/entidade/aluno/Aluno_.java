package modelo.entidade.aluno;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidade.atividadeAluno.AtividadeAluno;
import modelo.entidade.frequencia.Frequencia;
import modelo.entidade.turma.Turma;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Aluno.class)
public abstract class Aluno_ extends modelo.entidade.usuario.Usuario_ {

	public static volatile SingularAttribute<Aluno, Integer> idade;
	public static volatile ListAttribute<Aluno, AtividadeAluno> atividadesAluno;
	public static volatile SingularAttribute<Aluno, String> matricula;
	public static volatile ListAttribute<Aluno, Frequencia> frequencias;
	public static volatile SingularAttribute<Aluno, Turma> turma;
	public static volatile SingularAttribute<Aluno, String> nomeResponsavel;

	public static final String IDADE = "idade";
	public static final String ATIVIDADES_ALUNO = "atividadesAluno";
	public static final String MATRICULA = "matricula";
	public static final String FREQUENCIAS = "frequencias";
	public static final String TURMA = "turma";
	public static final String NOME_RESPONSAVEL = "nomeResponsavel";

}


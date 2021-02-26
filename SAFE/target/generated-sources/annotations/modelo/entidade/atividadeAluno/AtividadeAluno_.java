package modelo.entidade.atividadeAluno;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidade.aluno.Aluno;
import modelo.entidade.turma.Turma;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AtividadeAluno.class)
public abstract class AtividadeAluno_ {

	public static volatile SingularAttribute<AtividadeAluno, String> conteudo;
	public static volatile SingularAttribute<AtividadeAluno, Aluno> aluno;
	public static volatile SingularAttribute<AtividadeAluno, Boolean> entregue;
	public static volatile SingularAttribute<AtividadeAluno, Date> dataEntrega;
	public static volatile SingularAttribute<AtividadeAluno, Boolean> corrigido;
	public static volatile SingularAttribute<AtividadeAluno, Long> id;
	public static volatile SingularAttribute<AtividadeAluno, Turma> turma;
	public static volatile SingularAttribute<AtividadeAluno, String> nota;

	public static final String CONTEUDO = "conteudo";
	public static final String ALUNO = "aluno";
	public static final String ENTREGUE = "entregue";
	public static final String DATA_ENTREGA = "dataEntrega";
	public static final String CORRIGIDO = "corrigido";
	public static final String ID = "id";
	public static final String TURMA = "turma";
	public static final String NOTA = "nota";

}


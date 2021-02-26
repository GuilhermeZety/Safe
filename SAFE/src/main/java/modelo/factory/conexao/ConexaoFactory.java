package modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(modelo.entidade.professor.Professor.class);
		configuracao.addAnnotatedClass(modelo.entidade.turma.Turma.class);
		configuracao.addAnnotatedClass(modelo.entidade.frequencia.Frequencia.class);
		configuracao.addAnnotatedClass(modelo.entidade.extraAtividade.ExtraAtividade.class);
		configuracao.addAnnotatedClass(modelo.entidade.atividadeTurma.AtividadeTurma.class);
		configuracao.addAnnotatedClass(modelo.entidade.atividadeAluno.AtividadeAluno.class);
		configuracao.addAnnotatedClass(modelo.entidade.resumo.Resumo.class);
		configuracao.addAnnotatedClass(modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(modelo.entidade.administrador.Administrador.class);
		configuracao.addAnnotatedClass(modelo.entidade.aluno.Aluno.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}
}
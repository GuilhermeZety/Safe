import java.io.FileNotFoundException;
import java.util.List;

import modelo.dao.administrador.AdministradorDAO;
import modelo.dao.administrador.AdministradorDAOImpl;
import modelo.dao.aluno.AlunoDAO;
import modelo.dao.aluno.AlunoDAOImpl;
import modelo.dao.atividadeTurma.AtividadeTurmaDAO;
import modelo.dao.atividadeTurma.AtividadeTurmaDAOImpl;
import modelo.dao.professor.ProfessorDAO;
import modelo.dao.professor.ProfessorDAOImpl;
import modelo.dao.resumo.ResumoDAO;
import modelo.dao.resumo.ResumoDAOImpl;
import modelo.dao.turma.TurmaDAO;
import modelo.dao.turma.TurmaDAOImpl;
import modelo.entidade.administrador.Administrador;
import modelo.entidade.aluno.Aluno;
import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.professor.Professor;
import modelo.entidade.resumo.Resumo;
import modelo.entidade.turma.Turma;
import modelo.enumeracao.TipoEnsino;

public class principal {
	
	public static void main(String[] args) throws FileNotFoundException {
		
/********** DAO **********/
		AlunoDAO alunoDAO = new AlunoDAOImpl();
		AdministradorDAO adminDAO = new AdministradorDAOImpl();
		AtividadeTurmaDAO atividadeTurmaDAO = new AtividadeTurmaDAOImpl();
		ResumoDAO resumoDAO = new ResumoDAOImpl();
		TurmaDAO turmaDAO = new TurmaDAOImpl();
		ProfessorDAO professorDAO = new ProfessorDAOImpl();
		
		
/********** ADMINISTRADOR **********/
//		Administrador admin = new Administrador("Carlos","Gabriel", "43434343434", "carlos@email.com", "12345678");
//		adminDAO.inserirAdministrador(admin);
				
	
/********** TURMA **********/
//		Turma turma = new Turma("1", "A", TipoEnsino.ANOS_INICIAIS);
//		Turma turma2 = new Turma("7", "B", TipoEnsino.ENSINO_FUNDAMENTAL);
//		Turma turma3 = new Turma("2", "B", TipoEnsino.ENSINO_MEDIO);
//		turmaDAO.inserirTurma(turma);
//		turmaDAO.inserirTurma(turma2);
//		turmaDAO.inserirTurma(turma3);
		
		
/********** PROFESSOR **********/
//		List<Turma> turmas = turmaDAO.recuperarTurmas();
//		Professor professor = new Professor("Allan", "Sabino", "55555555555", "allan@email.com", "12345678", turmas);
//		Professor professor2 = new Professor("Simone", "Fraga", "47357538358", "simone@email.com", "87654321", turmas);
//		Turma turmaProfessor = turmaDAO.recuperarTurmaPeloId(new Turma(1L));
//		professorDAO.inserirProfessor(professor);
//		professorDAO.inserirProfessor(professor2);
//		turmaProfessor.adicionarProfessor(professorDAO.recuperarProfessorPeloId(new Professor(3L)));
//		turmaProfessor.adicionarProfessor(professorDAO.recuperarProfessorPeloId(new Professor(4L)));
//		turmaDAO.atualizarTurma(turmaProfessor);
			
		
/********** ALUNO **********/
//		Aluno aluno = new Aluno("Nicolas", "Seibel", 22, "235724852", "1", "Daniel", "nicolas@email.com", "12345678", turmaDAO.recuperarTurmaPeloId(new Turma(1L)));
//		Aluno aluno2 = new Aluno("Guilherme", "Martins", 22, "245614", "2", "Maria", "guilherme@email.com", "87654321", turmaDAO.recuperarTurmaPeloId(new Turma(1L)));
//		Aluno aluno3 = new Aluno("William", "Souza", 22, "1473585", "3", "Dorival", "william@email.com", "01020304", turmaDAO.recuperarTurmaPeloId(new Turma(2L)));
//		alunoDAO.inserirAluno(aluno);
//		alunoDAO.inserirAluno(aluno2);
//		alunoDAO.inserirAluno(aluno3);
		
		
/********** ATIVIDADE **********/
//		Professor professorAtividade = professorDAO.recuperarProfessorPeloId(new Professor(2L));
//		Professor professorAtividade2 = professorDAO.recuperarProfessorPeloId(new Professor(3L));
//		Turma turmaAtividade = turmaDAO.recuperarTurmaPeloId(new Turma(1L));
//		Turma turmaAtividade2 = turmaDAO.recuperarTurmaPeloId(new Turma(2L));
//		AtividadeTurma atividade = new AtividadeTurma("13/02/2021", "13/02/2021", "Matemática", "Atividade1", "conteudo atividade", professorAtividade, turmaDAO.recuperarTurmas());
//		AtividadeTurma atividade2 = new AtividadeTurma("13/02/2020", "13/02/2021", "Português", "Atividade2", "conteudo atividade", professorAtividade, turmaDAO.recuperarTurmas());
//		atividadeTurmaDAO.inserirAtividadeTurma(atividade);
//		atividadeTurmaDAO.inserirAtividadeTurma(atividade2);
//		professorAtividade.adicionarAtividade(atividadeTurmaDAO.recuperarAtividadeTurmaPeloId(new AtividadeTurma(1L)));
//		professorAtividade2.adicionarAtividade(atividadeTurmaDAO.recuperarAtividadeTurmaPeloId(new AtividadeTurma(2L)));
//		turmaAtividade.adicionarAtividadeTurma(atividadeTurmaDAO.recuperarAtividadeTurmaPeloId(new AtividadeTurma(1L)));
//		turmaAtividade2.adicionarAtividadeTurma(atividadeTurmaDAO.recuperarAtividadeTurmaPeloId(new AtividadeTurma(2L)));
//		professorDAO.atualizarProfessor(professorAtividade);
//		professorDAO.atualizarProfessor(professorAtividade2);
//		turmaDAO.atualizarTurma(turmaAtividade);
//		turmaDAO.atualizarTurma(turmaAtividade2);
//		AtividadeTurma aoj = atividadeTurmaDAO.recuperarAtividadeTurmaPeloId(new AtividadeTurma(1L));
//		AtividadeTurma a2oj = atividadeTurmaDAO.recuperarAtividadeTurmaPeloId(new AtividadeTurma(2L));
//		aoj.setProfessor(professorAtividade);
//		atividadeTurmaDAO.atualizarAtividadeTurma(aoj);
//		a2oj.setProfessor(professorAtividade2);
//		atividadeTurmaDAO.atualizarAtividadeTurma(a2oj);
		
/********** RESUMO **********/		
//		Professor professorResumo = professorDAO.recuperarProfessorPeloId(new Professor(2L));
//		Turma turmaResumo = turmaDAO.recuperarTurmaPeloId(new Turma(1L));
//		Resumo resumo = new Resumo("13/22/2021", "Português", professorResumo, turmaDAO.recuperarTurmas());
//		Resumo resumo2 = new Resumo("13/12/2021", "Física", professorResumo, turmaDAO.recuperarTurmas());
//		resumoDAO.inserirResumo(resumo);
//		resumoDAO.inserirResumo(resumo2);
//		professorResumo.adicionarResumo(resumo);
//		professorResumo.adicionarResumo(resumo2);
//		turmaResumo.adicionarResumo(resumo);
//		turmaResumo.adicionarResumo(resumo2);
//		professorDAO.atualizarProfessor(professorResumo);
//		turmaDAO.atualizarTurma(turmaResumo);
	}
}
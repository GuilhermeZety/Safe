package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.aluno.AlunoDAO;
import modelo.dao.aluno.AlunoDAOImpl;
import modelo.dao.atividadeTurma.AtividadeTurmaDAOImpl;
import modelo.dao.professor.ProfessorDAO;
import modelo.dao.professor.ProfessorDAOImpl;
import modelo.dao.turma.TurmaDAO;
import modelo.dao.turma.TurmaDAOImpl;
import modelo.entidade.aluno.Aluno;
import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.frequencia.Frequencia;
import modelo.entidade.professor.Professor;
import modelo.entidade.turma.Turma;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private ProfessorDAO professorDAO;
	private AlunoDAO alunoDAO;
	private TurmaDAO turmaDAO;

	public void init() {
		professorDAO = new ProfessorDAOImpl();
		alunoDAO = new AlunoDAOImpl();
		turmaDAO = new TurmaDAOImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		try {
			switch (action) {
				case "login":
					mostrarFormularioLoginProfessor(request, response);
					break;	
					
				case "logar":
					logarProfessor(request, response);
					break;	
					
				case "paginaInicial":
					mostrarPaginaInicialProfessor(request, response);
					break;
					
				case "enviar":
					mostrarEnviar(request, response);
					break;
					
				case "enviarAtividade":
					mostrarEnviarAtividade(request, response);
					break;
					
				case "enviarResumo":
					mostrarEnviarResumo(request, response);
					break;
					
				case "cadastro":
					mostrarCadastro(request, response);
					break;
					
				case "atividadeEnviada":
					atividadeEnviada(request, response);
					break;
					
				case "chamada":
					mostrarChamada(request, response);
					break;
					
				case "chamadaRealizada":
					chamadaRealizada(request, response);
					break;
					
				case "perfil":
					mostrarProfessorPerfil(request, response);
					break;
					
				case "atualizar":
					atualizarProfessor(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void mostrarFormularioLoginProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/professor-login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logarProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		if(cpf != null && senha != null) {
			Professor professor = professorDAO.recuperarProfessorPeloCpf(new Professor(cpf));
			if(professor != null) {
				if(professor.getSenha().equals(senha)) {
					request.getSession().setAttribute("professor", professor);
					response.sendRedirect("professor?action=paginaInicial");
				} else {
					response.sendRedirect("login");
				}
			} else {
				response.sendRedirect("login");
			}
		} else {
			response.sendRedirect("login");
		}
	}

	private void mostrarPaginaInicialProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Professor professor = (Professor) request.getSession().getAttribute("professor");
		List<AtividadeTurma> atividades = professor.getAtividades();
		List<AtividadeTurma> atividadesPaginaInicial = new ArrayList<AtividadeTurma>();
		int controle = 0;
		for (int i = 0; i < atividades.size(); i++) {
			controle++;
			if(controle < 3) {
				atividadesPaginaInicial.add(atividades.get(i));
			}
		}
		request.setAttribute("atividadesPaginaInicial", atividadesPaginaInicial);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/professor-pagina-inicial.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/cadastro-professor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarEnviar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/professor-enviar.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarEnviarAtividade(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = turmaDAO.recuperarTurmas();
		request.getSession().setAttribute("turmas", turmas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/enviar-atividade.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarEnviarResumo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = turmaDAO.recuperarTurmas();
		request.getSession().setAttribute("turmas", turmas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/professor-enviar-resumo.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atividadeEnviada(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = new ArrayList<Turma>();
		turmas.add(turmaDAO.recuperarTurmaPeloId(new Turma(Long.parseLong(request.getParameter("turma")))));
		Professor professor = (Professor) request.getSession().getAttribute("professor");
		String nome = request.getParameter("nome");
		String materia = request.getParameter("materia");
		String conteudo = request.getParameter("conteudo");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		AtividadeTurma atividade = new AtividadeTurma(sdf.format(new Date()), sdf.format(new Date()), materia, nome, conteudo, professor, turmas);
		new AtividadeTurmaDAOImpl().inserirAtividadeTurma(atividade);
		AtividadeTurma atividadeTurma = new AtividadeTurmaDAOImpl().recuperarAtividadeTurmaPeloNome(new AtividadeTurma(nome));
		for (Turma turma : turmas) {
			turma.adicionarAtividadeTurma(atividadeTurma);
			new TurmaDAOImpl().atualizarTurma(turma);
		}
		response.sendRedirect(request.getContextPath() + "/professor?action=paginaInicial");
	}
	
	private void mostrarChamada(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = turmaDAO.recuperarTurmas();
		request.getSession().setAttribute("turmas", turmas);
		List<Aluno> alunos = alunoDAO.recuperarAlunos();
		request.getSession().setAttribute("alunos", alunos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/professor-chamada.jsp");
		dispatcher.forward(request, response);
	}
	
	private void chamadaRealizada(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Turma turma = turmaDAO.recuperarTurmaPeloId(new Turma(Long.parseLong(request.getParameter("turma"))));
		List<Aluno> alunos = new AlunoDAOImpl().recuperarAlunos();
		for (Aluno aluno : alunos) {
			String estaPresente = request.getParameter("radio" + aluno.getId());
			Frequencia frequencia = new Frequencia(aluno, turma, estaPresente);
			aluno.adicionarFrequencia(frequencia);
			turma.adicionarFrequencia(frequencia);
			new AlunoDAOImpl().atualizarAluno(aluno);
			new TurmaDAOImpl().atualizarTurma(turma);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/professor-chamada.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarProfessorPerfil(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = turmaDAO.recuperarTurmas();
		request.getSession().setAttribute("turmas", turmas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/professor-perfil.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		List<Turma> turmas = new ArrayList<Turma>();
		turmas.add(turmaDAO.recuperarTurmaPeloId(new Turma(Long.parseLong(request.getParameter("turmas")))));		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		professorDAO.atualizarProfessor(new Professor(id, nome, sobrenome, cpf, email, senha, turmas));
		Professor professor = professorDAO.recuperarProfessorPeloId(new Professor(id));
		request.getSession().setAttribute("professor", professor);
		response.sendRedirect("professor?action=perfil");
	}
}
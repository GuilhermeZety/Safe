package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.administrador.AdministradorDAO;
import modelo.dao.administrador.AdministradorDAOImpl;
import modelo.dao.aluno.AlunoDAO;
import modelo.dao.aluno.AlunoDAOImpl;
import modelo.dao.atividadeTurma.AtividadeTurmaDAO;
import modelo.dao.atividadeTurma.AtividadeTurmaDAOImpl;
import modelo.dao.professor.ProfessorDAO;
import modelo.dao.professor.ProfessorDAOImpl;
import modelo.dao.turma.TurmaDAO;
import modelo.dao.turma.TurmaDAOImpl;
import modelo.entidade.administrador.Administrador;
import modelo.entidade.aluno.Aluno;
import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.professor.Professor;
import modelo.entidade.turma.Turma;

@WebServlet("/administrador")
public class AdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdministradorDAO adminDAO;
	private TurmaDAO turmaDAO;
	private AtividadeTurmaDAO atividadeTurmaDAO;
	private AlunoDAO alunoDAO;
	private ProfessorDAO professorDAO;
	
	public void init() {
		adminDAO = new AdministradorDAOImpl();
		turmaDAO = new TurmaDAOImpl();
		atividadeTurmaDAO = new AtividadeTurmaDAOImpl();
		alunoDAO = new AlunoDAOImpl();
		professorDAO = new ProfessorDAOImpl();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		try {
			switch (action) {
				case "login":
					mostrarFormularioLoginAdministrador(request, response);
					break;	
					
				case "logar":
					logarAdministrador(request, response);
					break;	
					
				case "paginaInicial":
					mostrarPaginaInicialAdministrador(request, response);
					break;
					
				case "atualizar":
					atualizarAdministrador(request, response);
					break;
					
				case "perfil":
					mostrarPerfilAdministrador(request, response);
					break;
					
				case "cadastros":
					mostrarCadastro(request, response);
					break;
					
				case "cadastroAluno":
					mostrarFormularioCadastroAluno(request, response);
					break;
					
				case "cadastroProfessor":
					mostrarFormularioCadastroProfessor(request, response);
					break;
					
				case "cadastrarAluno":
					cadastrarAluno(request, response);
					break;
					
				case "cadastrarProfessor":
					cadastrarProfessor(request, response);
					break;
					
				case "turmas":
					mostrarTurmas(request, response);
					break;
					
				case "atividades":
					mostrarAtividadesTurma(request, response);
					break;
					
				case "alunosAtividade":
					mostrarAlunosAtividade(request, response);
					break;
					
				case "alunoAtividade":
					mostrarAlunoAtividade(request, response);
					break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void mostrarFormularioLoginAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logarAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {	
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		if(cpf != null && senha != null) {
			Administrador admin = adminDAO.recuperarAdministradorPeloCpf(new Administrador(cpf));
			if(admin != null) {
				if(admin.getCpf().equals(cpf) && admin.getSenha().equals(senha)) {
					request.getSession().setAttribute("administrador", admin);
					response.sendRedirect("administrador?action=paginaInicial");
				} else {
					response.sendRedirect("administrador?action=login");
				}
			} else {
				response.sendRedirect("administrador?action=login");
			}
		} else {
			response.sendRedirect("administrador?action=login");
		}
	}
	
	private void mostrarPaginaInicialAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {	
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-pagina-inicial.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		adminDAO.atualizarAdministrador(new Administrador(id, nome, sobrenome, cpf, email, senha));
		Administrador admin = adminDAO.recuperarAdministradorPeloId(new Administrador(id));
		request.getSession().setAttribute("administrador", admin);
		response.sendRedirect("administrador?action=perfil");
	}
	
	private void mostrarPerfilAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-perfil.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-cadastros.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarFormularioCadastroAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = turmaDAO.recuperarTurmas();
		request.getSession().setAttribute("turmas", turmas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-cadastro-aluno.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarFormularioCadastroProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = turmaDAO.recuperarTurmas();
		request.getSession().setAttribute("turmas", turmas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-cadastro-professor.jsp");
		dispatcher.forward(request, response);
	}
	
	private void cadastrarAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		int idade = Integer.parseInt(request.getParameter("idade"));
		String cpf = request.getParameter("cpf");
		String matricula = request.getParameter("matricula");
		String responsavel = request.getParameter("responsavel");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Turma turma = turmaDAO.recuperarTurmaPeloId(new Turma(Long.parseLong(request.getParameter("turma"))));
		alunoDAO.inserirAluno(new Aluno(nome, sobrenome, idade, cpf, matricula, responsavel, email, senha, turma));
		turma.adicionarAluno(alunoDAO.recuperarAlunoPelaMatricula(new Aluno(matricula)));
		response.sendRedirect("administrador?action=cadastros");
	}
	
	private void cadastrarProfessor(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		List<Turma> turmas = new ArrayList<Turma>();
		turmas.add(turmaDAO.recuperarTurmaPeloId(new Turma(Long.parseLong(request.getParameter("turmas")))));
		professorDAO.inserirProfessor(new Professor(nome, sobrenome, cpf, email, senha, turmas));
		for (Turma turma : turmas) {
			turma.adicionarProfessor(professorDAO.recuperarProfessorPeloCpf(new Professor(cpf)));
			turmaDAO.atualizarTurma(turma);
		}
		response.sendRedirect("administrador?action=cadastros");
	}
	
	private void mostrarTurmas(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Turma> turmas = turmaDAO.recuperarTurmas();
		request.getSession().setAttribute("turmas", turmas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-turmas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarAtividadesTurma(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Turma turma = turmaDAO.recuperarTurmaPeloId(new Turma(Long.parseLong(request.getParameter("id"))));
		List<AtividadeTurma> atividades = turma.getAtividadesTurma();
		request.getSession().setAttribute("atividades", atividades);
		request.getSession().setAttribute("turma", turma);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-atividades-turma.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarAlunosAtividade(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Turma turma = (Turma) request.getSession().getAttribute("turma");
		AtividadeTurma atividade = atividadeTurmaDAO.recuperarAtividadeTurmaPeloId(new AtividadeTurma(Long.parseLong(request.getParameter("id"))));
		List<Aluno> alunos = turma.getAlunos();
		request.getSession().setAttribute("atividade", atividade);
		request.getSession().setAttribute("alunos", alunos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-atividades-turma-alunos.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarAlunoAtividade(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(Long.parseLong(request.getParameter("id"))));
		request.getSession().setAttribute("aluno", aluno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/administrador-aluno-atividades.jsp");
		dispatcher.forward(request, response);
	}
}

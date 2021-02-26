package controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
import modelo.entidade.aluno.Aluno;
import modelo.entidade.atividadeAluno.AtividadeAluno;
import modelo.entidade.atividadeTurma.AtividadeTurma;
import modelo.entidade.resumo.Resumo;
import modelo.entidade.turma.Turma;

@WebServlet("/aluno")
public class AlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AlunoDAO alunoDAO = new AlunoDAOImpl();

	public void init() {
		alunoDAO = new AlunoDAOImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		try {
			switch (action) {
				case "login":
					mostrarFormularioLoginAluno(request, response);
					break;	
					
				case "logar":
					logarAluno(request, response);
					break;	
					
				case "paginaInicial":
					mostrarPaginaInicialAluno(request, response);
					break;
					
				case "atividades":
					mostrarAtividadesAluno(request, response);
					break;
					
				case "infoAtividade":
					mostrarInfoAtividadeAluno(request, response);
					break;
					
				case "perfil":
					mostrarPerfilAluno(request, response);
					break;
					
				case "atualizar":
					atualizarAluno(request, response);
					break;
					
				case "notas":
					mostrarNotasAluno(request, response);
					break;
					
				case "cadastro":
					mostrarCadastro(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void mostrarFormularioLoginAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/aluno-login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void logarAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {	
		String matricula = request.getParameter("matricula");
		String senha = request.getParameter("senha");
		
		if(matricula != null && senha != null) {
			Aluno aluno = alunoDAO.recuperarAlunoPelaMatricula(new Aluno(matricula));
			if(aluno != null) {
				if(aluno.getSenha().equals(senha)) {
					request.getSession().setAttribute("aluno", aluno);
					response.sendRedirect("aluno?action=paginaInicial");
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

	private void mostrarPaginaInicialAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");
		Turma turma = aluno.getTurma();
		List<AtividadeAluno> atividades = aluno.getAtividadesAluno();
		List<Resumo> resumos = turma.getResumos();
		request.getSession().setAttribute("atividades", atividades);
		request.getSession().setAttribute("resumos", resumos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/aluno-pagina-inicial.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Aluno alunoSessao = (Aluno) request.getSession().getAttribute("aluno");
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		int idade = Integer.parseInt(request.getParameter("idade"));
		String cpf = request.getParameter("cpf");
		String matricula = request.getParameter("matricula");
		String responsavel = request.getParameter("responsavel");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Turma turma = alunoSessao.getTurma();
		alunoDAO.atualizarAluno(new Aluno(id, nome, sobrenome, idade, cpf, matricula, responsavel, email, senha, turma));
		Aluno aluno = alunoDAO.recuperarAlunoPeloId(new Aluno(id));
		request.getSession().setAttribute("aluno", aluno);
		response.sendRedirect("aluno?action=perfil");
	}
	
	private void mostrarNotasAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/aluno-notas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarAtividadesAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");
		Turma turma = aluno.getTurma();
		List<AtividadeAluno> atividades = aluno.getAtividadesAluno();
		List<Resumo> resumos = turma.getResumos();
		request.getSession().setAttribute("atividades", atividades);
		request.getSession().setAttribute("resumos", resumos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/aluno-atividades.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarInfoAtividadeAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		AtividadeTurma atividade = new AtividadeTurmaDAOImpl().recuperarAtividadeTurmaPeloId(new AtividadeTurma(Long.parseLong(request.getParameter("id"))));
		request.setAttribute("atividade", atividade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/aluno-info-atividade.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarPerfilAluno(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/aluno-perfil.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/cadastro-aluno.jsp");
		dispatcher.forward(request, response);
	}
}

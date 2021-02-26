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
import modelo.entidade.aluno.Aluno;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/html/cadastro.jsp");
		dispatcher.forward(request, response);
	}
}
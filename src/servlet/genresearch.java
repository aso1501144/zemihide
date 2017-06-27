package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDAO;
import model.Subject;

/**
 * Servlet implementation class genresearch
 */
@WebServlet("/genresearch")
public class genresearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public genresearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		HttpSession session = request.getSession();

		SubjectDAO dao = new SubjectDAO();
		ArrayList<Subject> subjects = new ArrayList<Subject>();

		String genre = request.getParameter("genre");
		switch (genre) {
		case "eng":
			genre = "英語";
			subjects = dao.genresearch(genre);
			break;

		case "com":
			genre = "コミュニケーション";
			subjects = dao.genresearch(genre);
			break;

		case "it":
			subjects = dao.genresearch(genre);
			break;

		default:
			subjects = dao.getData();
			break;
		}

		session.setAttribute("subject", subjects);

		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/userEntry.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		HttpSession session = request.getSession();

		SubjectDAO dao = new SubjectDAO();
		ArrayList<Subject> subjects = new ArrayList<Subject>();

		String genre = request.getParameter("genre");
		switch (genre) {
		case "eng":
			genre = "英語";
			subjects = dao.genresearch(genre);
			break;

		case "com":
			genre = "コミュニケーション";
			subjects = dao.genresearch(genre);
			break;

		case "it":
			subjects = dao.genresearch(genre);
			break;

		default:
			subjects = dao.getData();
			break;
		}

		session.setAttribute("subject", subjects);

		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/subjectList.jsp");
		dis.forward(request, response);
	}

}

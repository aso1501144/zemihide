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
 * Servlet implementation class SubjectDelete
 */
@WebServlet("/MSubDelete")
public class MSubDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/subjectDelete.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String sub_id = (String) session.getAttribute("sub_id");
		SubjectDAO dao = new SubjectDAO();
		dao.deleteSub(sub_id);

		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		subjectList = dao.getData();

		session.setAttribute("subject", subjectList);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/subjectList.jsp");
		rd.forward(request, response);
	}

}

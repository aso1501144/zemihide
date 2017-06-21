package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDAO;

/**
 * Servlet implementation class ChangeSubject
 */
@WebServlet("/SubjectChange")
public class SubjectChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		// ユーザーID、パスワードの取り出し

		String get =  request.getParameter("sub_id");
		String num =  request.getParameter("num");


		System.out.println(get);

		SubjectDAO subject= new SubjectDAO();
		String name = subject.subname(get);
		System.out.println(name);

		session.setAttribute("num", num);
		session.setAttribute("sub", name);



		//科目名を受け取るやつここに書く
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userchange.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

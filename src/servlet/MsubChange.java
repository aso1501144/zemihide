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
import model.UserBean;

/**
 * Servlet implementation class MsubChange
 */
@WebServlet("/MsubChange")
public class MsubChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MsubChange() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String get =  request.getParameter("sub_id");
		int num =  Integer.parseInt(request.getParameter("num"));
		System.out.println(get);
		System.out.println(num);

		SubjectDAO subject= new SubjectDAO();
		String name = subject.subname(get);
		System.out.println(name);

		request.setAttribute("sub", name);
		request.setAttribute("sub_id", get);

		if (num == 1) {
			session.setAttribute("sub_name", name);
			session.setAttribute("sub_id", get);
			// 科目名を受け取るやつここに書く
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/subjectChange.jsp");
			rd.forward(request, response);

		} else {
			ArrayList<UserBean> list = new ArrayList<UserBean>();
			SubjectDAO dao = new SubjectDAO();
			list = dao.entrylist(get);

			session.setAttribute("sslist", list);
			session.setAttribute("sub_name", name);
			session.setAttribute("sub_id", get);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ssList.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}

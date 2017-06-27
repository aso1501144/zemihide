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
 * Servlet implementation class SubEntry
 */
@WebServlet("/SubEntry")
public class SubEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String get =  request.getParameter("sub_id");
		int num =  Integer.parseInt(request.getParameter("flg"));
		System.out.println(get);
		System.out.println(num);

		SubjectDAO subject= new SubjectDAO();
		String name = subject.subname(get);
		System.out.println(name);

		request.setAttribute("sub", name);
		request.setAttribute("sub_id", get);
		//科目名を受け取るやつここに書く
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/subjectRegistration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		int flg = 0;
		String subName = request.getParameter("subjectName");
		int genre = Integer.parseInt(request.getParameter("genre"));
		int sub_id = Integer.parseInt(request.getParameter("sub_id"));
		flg = Integer.parseInt(request.getParameter("flg"));

		SubjectDAO subDAO = new SubjectDAO();
		if(flg == 0) {
			subDAO.insertSub(subName,genre);
		} else {
			subDAO.updataSub(subName,genre,sub_id);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/subjectList.jsp");
		rd.forward(request, response);

	}

}

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

import dao.EntryDAO;
import dao.UserDAO;
import model.EntryBean;

/**
 * Servlet implementation class SubjectDelete
 */
@WebServlet("/SubjectDelete")
public class SubjectDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String s_id= (String) session.getAttribute("s_id");
		String sub_id= (String) session.getAttribute("sub");
		String num = (String) session.getAttribute("num");

		ArrayList<EntryBean> entryList = new ArrayList<EntryBean>();
		entryList = (ArrayList<EntryBean>) session.getAttribute("entry");

		UserDAO subject= new UserDAO();

		if("1".equals(num) ){
			subject.subdel(s_id);
		}else{
			subject.subdel2(s_id);
		}
		EntryDAO entry = new EntryDAO();
		entryList = entry.getData(Integer.parseInt(s_id));

		session.setAttribute("entry", entryList);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

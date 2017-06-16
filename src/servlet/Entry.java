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
import dao.SubjectDAO;
import model.EntryBean;

/**
 * Servlet implementation class Entry
 */
@WebServlet("/Entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntryDAO entry = new EntryDAO();
		//ArrayList<EntryBean> eb = entry.getData(request.getParameter("student"));
		//int size =eb.size();
		//request.setAttribute("length", size);
		//request.setAttribute("product", eb);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/entry.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		// ユーザーID、パスワードの取り出し

		String s_id = (String) session.getAttribute("s_id");

		String get =  request.getParameter("sub_ident");

		System.out.println(get);

		EntryDAO entry = new EntryDAO();
		SubjectDAO subject= new SubjectDAO();
		subject.subentry(s_id, get);


		ArrayList<EntryBean> entryList = new ArrayList<EntryBean>();
		entryList = entry.getData(Integer.parseInt(s_id));

		session.setAttribute("entry", entryList);

		//科目名を受け取るやつここに書く
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		rd.forward(request, response);
	}

}

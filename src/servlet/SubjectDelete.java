package servlet;

import java.io.IOException;
import java.util.ArrayList;

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

		String subdel = (String) session.getAttribute("s_id");
		String num = (String) session.getAttribute("num");


		UserDAO subject= new UserDAO();
		if(num.equals("1") ){
			subject.subdel(subdel);
		}else{
			subject.subdel2(subdel);
		}

		EntryDAO entry = new EntryDAO();
		ArrayList<EntryBean> entryList = new ArrayList<EntryBean>();
		entryList = entry.getData(Integer.parseInt(subdel));

		session.setAttribute("entry", entryList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

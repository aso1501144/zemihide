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
 * Servlet implementation class userlogin
 */
@WebServlet("/userlogin")
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userlogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.invalidate();

		RequestDispatcher dis3 = request.getRequestDispatcher("/WEB-INF/jsp/userLogin.jsp");
		dis3.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path; // 分岐先のファイル名
		HttpSession session = request.getSession();
		// ユーザーID、パスワードの取り出し

		String get = request.getParameter("s_id");
		int s_id = 0;
		if (number(get)) {
			s_id = Integer.parseInt(get);
		} else {
			request.setAttribute("errorMassage", "学生IDまたはパスワードが違います。");
			RequestDispatcher dis2 = request.getRequestDispatcher("WEB-INF/jsp/userLogin.jsp");
			dis2.forward(request, response);
			return;
		}

		String pass = request.getParameter("pass");
		UserDAO userDAO = new UserDAO();
		//UserBean user = new UserBean();

		String login = userDAO.getLogin(s_id, pass);

		if (login != null) {
			// 会員情報をセッションに格納
			session.setAttribute("s_id", login);
			session.setAttribute("s_name", userDAO.getSname(s_id));

			EntryDAO entry = new EntryDAO();
			ArrayList<EntryBean> entryList = new ArrayList<EntryBean>();
			entryList = entry.getData(s_id);

			session.setAttribute("entry", entryList);

			path = "WEB-INF/jsp/list.jsp";

		} else {
			System.out.println("ログイン失敗");
			request.setAttribute("errorMassage", "学生IDまたはパスワードが違います。");
			path = "WEB-INF/jsp/userLogin.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	public boolean number(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}

	}
}

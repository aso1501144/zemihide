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
import model.UserBean;

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

		String get =  request.getParameter("s_id");
		int s_id = 0;
		if(number(get)){
			s_id = Integer.parseInt(get);
		}else{
			System.out.println("ログイン失敗あああ");
			RequestDispatcher dis2 = request.getRequestDispatcher("WEB-INF/jsp/userLogin.jsp");
			dis2.forward(request, response);
			return;
		}


		//int s_id = Integer.parseInt(request.getParameter("s_id"));

		// String s_name = request.getParameter("s_name");
		String pass = request.getParameter("pass");
		// int c_id = Integer.parseInt(request.getParameter("c_id"));
		UserDAO userDAO = new UserDAO();
		UserBean user = new UserBean();
		// UserBean userBean = new UserBean();
		// ArrayList<UserBean> list = new ArrayList<UserBean>();
		// UserDAO UserDAO = new UserDAO();
		// IDとパスワードを使ってログインユーザー情報を受け取る
		user = userDAO.getData(s_id, pass);

		if (user != null) {
			System.out.println("ログイン成功");
			// 会員情報をセッションに格納
			session.setAttribute("CommonLoginMember", user);
			// userBean = userDAO.getData(s_id, pass);
			// session.setAttribute("list", userBean);

			EntryDAO entry = new EntryDAO();
			ArrayList<EntryBean> entryList = new ArrayList<EntryBean>();
			entryList = entry.getData(s_id);

			session.setAttribute("entry", entryList);

			path = "WEB-INF/jsp/list.jsp";

		} else {
			System.out.println("ログイン失敗");
			request.setAttribute("errorMassage", "会員IDまたはパスワードが違います。");
			path = "WEB-INF/jsp/userLogin.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	public boolean number(String num){
		try{
			Integer.parseInt(num);
			return true;
		}catch (NumberFormatException e) {
				// TODO: handle exception
				return false;
			}

	}
}

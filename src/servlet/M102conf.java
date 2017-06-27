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

import dao.ManagerDAO;
import dao.SubjectDAO;
import model.Subject;

/**
 * Servlet implementation class M102conf
 */
@WebServlet("/M102conf")
public class M102conf extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public M102conf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/subjectList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path; // 分岐先のファイル名
		HttpSession session = request.getSession();
		// ユーザーID、パスワードの取り出し

		String get =  request.getParameter("m_id");
		int m_id = 0;
		if(number(get)){
			m_id = Integer.parseInt(get);
		}else{
			request.setAttribute("errorMassage", "会員IDまたはパスワードが違います。");
			RequestDispatcher dis2 = request.getRequestDispatcher("WEB-INF/jsp/managerLogin.jsp");
			dis2.forward(request, response);
			return;
		}

		String pass = request.getParameter("pass");
		ManagerDAO managerDAO = new ManagerDAO();
		String login = managerDAO.getLogin(m_id,pass);

		if (login != null) {
			// 会員情報をセッションに格納
			session.setAttribute("m_id", login);
			session.setAttribute("m_name", managerDAO.getMname(m_id));

			SubjectDAO subDAO = new SubjectDAO();
			ArrayList<Subject> subjectList = new ArrayList<Subject>();
			subjectList = subDAO.getData();

			session.setAttribute("subject", subjectList);

			path = "WEB-INF/jsp/subjectList.jsp";

		} else {
			request.setAttribute("errorMassage", "会員IDまたはパスワードが違います。");
			path = "WEB-INF/jsp/managerLogin.jsp";
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


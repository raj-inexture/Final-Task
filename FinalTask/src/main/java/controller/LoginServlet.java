package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserDetailsBeanModel;
import model.UserLogsBeanModel;
import service.AdminUserLoginImpl;
import service.AdminUserLoginInterface;
import service.UserLogsImpl;
import service.UserLogsInterface;
import util.PasswordMethods;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PasswordMethods pass = new PasswordMethods();

		String encryptedPassword = pass.encrypt(password);

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(username);
		user.setPassword(encryptedPassword);

		AdminUserLoginInterface login = new AdminUserLoginImpl();

		user = login.authenticateUser(user);

		if (user != null && user.getUserrole().equals("Admin")) {

			HttpSession session = request.getSession();

			UserLogsBeanModel userlogs = new UserLogsBeanModel();

			userlogs.setUserid(user.getUserid());

			UserLogsInterface logs = new UserLogsImpl();

			int result = logs.addStartStamp(userlogs);

			logs.setID(userlogs);

			request.setAttribute("email", user.getEmail());
			request.setAttribute("logid", userlogs.getId());

			session.setAttribute("email", user.getEmail());
			session.setAttribute("logid", userlogs.getId());

			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);

//			RequestDispatcher rd = request.getRequestDispatcher("UserLogsServlet");
//			rd.forward(request, response);

		} else if (user != null && user.getUserrole().equals("User")) {

			HttpSession session = request.getSession();

			UserLogsBeanModel userlogs = new UserLogsBeanModel();

			userlogs.setUserid(user.getUserid());

			UserLogsInterface logs = new UserLogsImpl();

			int result = logs.addStartStamp(userlogs);

			logs.setID(userlogs);

			request.setAttribute("email", user.getEmail());
			request.setAttribute("logid", userlogs.getId());

			session.setAttribute("email", user.getEmail());
			session.setAttribute("logid", userlogs.getId());

			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}

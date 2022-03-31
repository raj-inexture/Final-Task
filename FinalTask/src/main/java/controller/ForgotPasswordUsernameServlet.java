package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDetailsBeanModel;
import service.ForgotPassword;

/**
 * Servlet implementation class ForgotPasswordUsernameServlet
 */
public class ForgotPasswordUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordUsernameServlet() {
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

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(username);

		user = ForgotPassword.authenticateUsername(user);

		if (user != null) {

			request.setAttribute("email", user.getEmail());

			RequestDispatcher rd = request.getRequestDispatcher("ForgotPasswordQuestion.jsp");
			rd.forward(request, response);

		} else {
			response.sendRedirect("ForgotPasswordUsername.jsp");
		}
	}

}

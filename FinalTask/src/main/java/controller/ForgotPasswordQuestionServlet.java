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
 * Servlet implementation class ForgotPasswordQuestionServlet
 */
public class ForgotPasswordQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordQuestionServlet() {
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

		String email = request.getParameter("email");
		String securityquestion = request.getParameter("securityquestion");
		String securityanswer = request.getParameter("securityanswer");

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(email);
		user.setSecurityquestion(securityquestion);
		user.setSecurityanswer(securityanswer);

		user = ForgotPassword.authenticateUserSecurity(user);

		if (user != null) {

			request.setAttribute("email", user.getEmail());

			RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);

		} else {
			response.sendRedirect("ForgotPasswordUsername.jsp");
		}
	}

}

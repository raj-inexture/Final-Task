package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDetailsBeanModel;
import service.ForgotPasswordImpl;
import service.ForgotPasswordInterface;
import util.PasswordMethods;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
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

		String email;

		email = request.getParameter("email");

		if (email == null) {
			email = (String) request.getAttribute("email");
		}

		out.println("here" + email + "end");

		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");

		PasswordMethods pass = new PasswordMethods();

		String encryptedPassword = pass.encrypt(password);

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(email);
		user.setPassword(encryptedPassword);

		ForgotPasswordInterface forgotPassword = new ForgotPasswordImpl();

		int result = forgotPassword.changePassword(user);

		if (result != 0) {

			request.removeAttribute("email");

			response.sendRedirect("login.jsp");

		} else {
			response.sendRedirect("ForgotPasswordUsername.jsp");
		}
	}

}

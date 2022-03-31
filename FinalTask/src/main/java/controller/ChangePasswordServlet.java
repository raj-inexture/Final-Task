package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDetailsBeanModel;
import service.ForgotPassword;

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

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");

		String hashedPassword = "";
		MessageDigest crypt = null;

		try {

			crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(password.getBytes("UTF-8"));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Formatter formatter = new Formatter();

		for (byte b : crypt.digest()) {

			formatter.format("%2x", b);

		}

		hashedPassword = formatter.toString();

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(email);
		user.setPassword(hashedPassword);

		int result = ForgotPassword.changePassword(user);

		if (result != 0) {

			request.removeAttribute("email");

			response.sendRedirect("login.jsp");

		} else {
			response.sendRedirect("ForgotPasswordUsername.jsp");
		}
	}

}

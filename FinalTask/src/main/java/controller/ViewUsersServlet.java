package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import model.AddressBeanModel;
import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;
import service.ViewUsersImpl;
import service.ViewUsersInterface;
import util.PasswordMethods;

/**
 * Servlet implementation class ViewUsersServlet
 */
public class ViewUsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUsersServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(email);

		ViewUsersInterface viewUsers = new ViewUsersImpl();

		user = viewUsers.viewUserDetails(user);

		PasswordMethods pass = new PasswordMethods();

		String decryptedPassword = pass.decrypt(user.getPassword());

		user.setPassword(decryptedPassword);

		if (user != null) {
			request.setAttribute("user", user);
			request.setAttribute("email", user.getEmail());

			List<AddressBeanModel> listAddress = new LinkedList<AddressBeanModel>();

			listAddress = viewUsers.viewUserAddress(user.getUserid());

			request.setAttribute("addresslist", listAddress);

			List<TechnologiesBeanModel> listTechnology = new LinkedList<TechnologiesBeanModel>();

			listTechnology = viewUsers.viewUserTechnology(user.getUserid());

			request.setAttribute("technologylist", listTechnology);

			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			rd.forward(request, response);
		} else {
			out.println("No Such User Found");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(email);

		List<UserDetailsBeanModel> listUser = new LinkedList<UserDetailsBeanModel>();

		ViewUsersInterface viewUsers = new ViewUsersImpl();

		listUser = viewUsers.viewUserData(user);

		user = viewUsers.viewUserDetails(user);

		PasswordMethods pass = new PasswordMethods();

		String decryptedPassword = pass.decrypt(user.getPassword());

		user.setPassword(decryptedPassword);

		if (user != null) {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonObject json = new JsonObject();
			json.add("data", gson.toJsonTree(listUser));
			out.print(json);

		} else {
			out.println("No Such User Found");
		}

	}

}

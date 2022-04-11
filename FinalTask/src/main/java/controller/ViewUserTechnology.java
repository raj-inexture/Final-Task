package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;
import service.ViewUsersImpl;
import service.ViewUsersInterface;

/**
 * Servlet implementation class ViewUserTechnology
 */
public class ViewUserTechnology extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUserTechnology() {
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

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		user.setEmail(email);

		ViewUsersInterface viewUsers = new ViewUsersImpl();

		user = viewUsers.viewUserDetails(user);

		List<TechnologiesBeanModel> listTechhnology = new LinkedList<TechnologiesBeanModel>();

		listTechhnology = viewUsers.viewUserTechnology(user.getUserid());

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject jsonAddress = new JsonObject();
		jsonAddress.add("technologies", gson.toJsonTree(listTechhnology));
		out.print(jsonAddress);
	}

}

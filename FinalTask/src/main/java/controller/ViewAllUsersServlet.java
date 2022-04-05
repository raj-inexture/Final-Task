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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import model.UserDetailsBeanModel;
import service.ViewUsersImpl;
import service.ViewUsersInterface;

/**
 * Servlet implementation class ViewAllUsersServlet
 */
public class ViewAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllUsersServlet() {
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

		PrintWriter out = response.getWriter();

		UserDetailsBeanModel user = new UserDetailsBeanModel();

		ViewUsersInterface viewUsers = new ViewUsersImpl();

		List<UserDetailsBeanModel> listUser = new LinkedList<UserDetailsBeanModel>();

		listUser = viewUsers.viewAllUserDetails(user);

		JsonObject jsonResponse = new JsonObject();

		Gson gson = new Gson();

		JsonArray data = new JsonArray();

		for (UserDetailsBeanModel users : listUser) {
			JsonArray row = new JsonArray();

			row.add(new JsonPrimitive(users.getUserid()));
			row.add(new JsonPrimitive(users.getFirstname()));
			row.add(new JsonPrimitive(users.getLastname()));
			row.add(new JsonPrimitive(users.getEmail()));
			row.add(new JsonPrimitive(users.getPhone()));

			data.add(row);
		}
		jsonResponse.add("usersData", data);

		response.setContentType("application/json");
		response.getWriter().print(jsonResponse.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}

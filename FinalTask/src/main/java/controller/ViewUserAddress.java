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

import model.AddressBeanModel;
import model.UserDetailsBeanModel;
import service.ViewUsersImpl;
import service.ViewUsersInterface;

/**
 * Servlet implementation class ViewUserAddress
 */
public class ViewUserAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUserAddress() {
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

		List<AddressBeanModel> listAddress = new LinkedList<AddressBeanModel>();

		listAddress = viewUsers.viewUserAddress(user.getUserid());

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject jsonAddress = new JsonObject();
		jsonAddress.add("addressData", gson.toJsonTree(listAddress));
		out.print(jsonAddress);
	}
}

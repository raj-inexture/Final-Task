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

import model.UserLogsBeanModel;
import service.UserLogsImpl;
import service.UserLogsInterface;

/**
 * Servlet implementation class UserLogsServlet
 */
public class UserLogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogsServlet() {
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

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		UserLogsInterface userLogs = new UserLogsImpl();

		List<UserLogsBeanModel> listLogs = new LinkedList<UserLogsBeanModel>();

		listLogs = userLogs.viewAllUserLogs();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject jsonLogs = new JsonObject();
		jsonLogs.add("logsData", gson.toJsonTree(listLogs));
		out.print(jsonLogs);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		UserLogsInterface userLogs = new UserLogsImpl();
//
//		userLogs.userLogs();
//
//		out.println("Generated CSV File Successfully!");

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		UserLogsInterface userLogs = new UserLogsImpl();

		List<UserLogsBeanModel> listLogs = new LinkedList<UserLogsBeanModel>();

		listLogs = userLogs.viewAllUserLogs();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject jsonLogs = new JsonObject();
		jsonLogs.add("logsData", gson.toJsonTree(listLogs));
		out.print(jsonLogs);
	}

}

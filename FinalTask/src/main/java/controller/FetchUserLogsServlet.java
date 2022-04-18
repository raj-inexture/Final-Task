package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class FetchUserLogsServlet
 */
public class FetchUserLogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FetchUserLogsServlet() {
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

		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");

		if (starttime.equals("") || endtime.equals("") || starttime.equals(null) || endtime.equals(null)) {
			starttime = "00:00:00";
			endtime = "23:59:59";
		}

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		DateFormat targetformatter = new SimpleDateFormat("yyyy-MM-dd");

		Date sDate = null;
		Date eDate = null;

		try {
			sDate = (Date) formatter.parse(startdate);
			eDate = (Date) formatter.parse(enddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String startingDate = targetformatter.format(sDate);
		String endingDate = targetformatter.format(eDate);

		UserLogsInterface userLogs = new UserLogsImpl();

		List<UserLogsBeanModel> fetchLogs = new LinkedList<UserLogsBeanModel>();

		fetchLogs = userLogs.fetchUserLogs(startingDate, endingDate, starttime, endtime);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonObject jsonLogs = new JsonObject();
		jsonLogs.add("fetchLogsData", gson.toJsonTree(fetchLogs));
		out.print(jsonLogs);

	}

}

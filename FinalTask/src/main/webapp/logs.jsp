<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Logs</title>
</head>
<body>
	<table>
		<%
	String filename = "D:\\Java Training\\FinalTask\\userlogs.csv";
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3333/";
	String dbName = "finaltaskdb";
	String driver = "com.mysql.cj.jdbc.Driver";
	String userName = "root";
	String password = "admin";
	Statement stmt;
	try {
		FileWriter fw = new FileWriter(filename);
		fw.append("USER ID");
		fw.append(',');
		fw.append("START TIMESTAMP");
		fw.append(',');
		fw.append("END TIMESTAMP");
		fw.append('\n');

		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, password);
		String query = "select userid, startstamp, endstamp from userlogs";
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			fw.append(rs.getString(1));
			fw.append(',');
			fw.append(rs.getString(2));
			fw.append(',');
			fw.append(rs.getString(3));
			fw.append('\n');
		}
		fw.flush();
		fw.close();
		conn.close();
		out.println("<b>You are Successfully Created Csv file.</b>");
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	</table>
</body>
</html>
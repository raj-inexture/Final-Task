package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static DatabaseConnection dbInstance;
	private static Connection conn;

	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String CONNECTION_URL = "jdbc:mysql://localhost:3333/finaltaskdb";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";

	private DatabaseConnection() {
	}

	public static DatabaseConnection getInstance() {

		if (dbInstance == null) {
			dbInstance = new DatabaseConnection();
		}

		return dbInstance;
	}

	public static Connection getConnection() {

		try {

			Class.forName(DRIVER_CLASS);

			conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {

			System.out.println("Error: Unable to load Driver Class!");
			System.exit(1);

		} catch (SQLException e) {

			System.out.println("Error: SQL Exception!");
			System.exit(1);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return conn;
	}

}

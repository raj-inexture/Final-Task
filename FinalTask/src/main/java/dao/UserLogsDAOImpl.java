package dao;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.UserLogsBeanModel;
import util.DatabaseConnection;

public class UserLogsDAOImpl implements UserLogsDAOInterface {

	static Connection conn;

	public void userLogs() {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			String filename = "D:\\Java Training\\FinalTask\\userlogs.csv";

			FileWriter fw = new FileWriter(filename);
			fw.append("USER ID");
			fw.append(',');
			fw.append("START TIMESTAMP");
			fw.append(',');
			fw.append("END TIMESTAMP");
			fw.append('\n');

			PreparedStatement stmt = conn.prepareStatement(
					"select userlogs.userid, userlogs.startstamp, userlogs.endstamp from userlogs inner join userdetails on userdetails.userid = userlogs.userid where userdetails.userrole = ?");

			stmt.setString(1, "User");

			ResultSet rs = stmt.executeQuery();

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

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<UserLogsBeanModel> viewAllUserLogs() {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			List<UserLogsBeanModel> logsList = new LinkedList<UserLogsBeanModel>();

			PreparedStatement stmt = conn.prepareStatement(
					"select userlogs.userid, userlogs.startstamp, userlogs.endstamp from userlogs inner join userdetails on userdetails.userid = userlogs.userid where userdetails.userrole = ?");

			stmt.setString(1, "User");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserLogsBeanModel logs = new UserLogsBeanModel();

				logs.setUserid(rs.getInt(1));
				logs.setStartstamp(rs.getTimestamp(2));
				logs.setEndstamp(rs.getTimestamp(3));

				logsList.add(logs);
			}

			return logsList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int addStartStamp(UserLogsBeanModel userlogs) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("insert into userlogs (userid, startstamp) values(?, now())");

			stmt.setInt(1, userlogs.getUserid());

			i = stmt.executeUpdate();

			if (i != 0) {
				return i;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public UserLogsBeanModel setID(UserLogsBeanModel userlogs) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("select id from userlogs where userid = ?  order by id desc limit 1;");

			stmt.setInt(1, userlogs.getUserid());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				userlogs.setId(rs.getInt(1));

				return userlogs;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int addEndStamp(UserLogsBeanModel userlogs) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("update userlogs set endstamp = now() where id = ?;");

			stmt.setInt(1, userlogs.getId());

			i = stmt.executeUpdate();

			if (i != 0) {
				return i;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}

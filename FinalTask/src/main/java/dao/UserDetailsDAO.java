package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.UserDetailsBeanModel;
import util.DatabaseConnection;

public class UserDetailsDAO {

	public static int nextKey() {

		int key = 0;

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("select Max(userid) from userdetails");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				key = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return key + 1;
	}

	public static int addUser(UserDetailsBeanModel user) {

		int i = 0;

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(
					"insert into userdetails (userid, firstname, lastname, email, gender, dob, phone, password, userrole, securityquestion, securityanswer) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, nextKey());
			stmt.setString(2, user.getFirstname());
			stmt.setString(3, user.getLastname());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getDob());
			stmt.setString(7, user.getPhone());
			stmt.setString(8, user.getPassword());
			stmt.setString(9, user.getUserrole());
			stmt.setString(10, user.getSecurityquestion());
			stmt.setString(11, user.getSecurityanswer());

			user.setUserid(nextKey());

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

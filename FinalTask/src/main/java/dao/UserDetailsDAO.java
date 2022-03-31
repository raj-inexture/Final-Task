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
					"insert into userdetails (userid, firstname, lastname, email, gender, dob, phone, password, userrole, securityquestion, securityanswer) values(?, ?, ?, ?, ?, str_to_date(?,'%d/%m/%Y'), ?, ?, ?, ?, ?)");

			stmt.setInt(1, nextKey());
			stmt.setString(2, user.getFirstname());
			stmt.setString(3, user.getLastname());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getDob());
			stmt.setString(7, user.getPhone());
			stmt.setString(8, user.getPassword());
			stmt.setString(9, "User");
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

	public static UserDetailsBeanModel authenticateUser(UserDetailsBeanModel user) {

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(
					"select userid, firstname, lastname, email, phone, userrole from userdetails where (email = ? or phone = ?) and password = ?");

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setUserrole(rs.getString(6));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static UserDetailsBeanModel authenticateUsername(UserDetailsBeanModel user) {

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(
					"select userid, email, phone, userrole, securityquestion, securityanswer from userdetails where (email = ? or phone = ?)");

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getEmail());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setUserrole(rs.getString(4));
				user.setSecurityquestion(rs.getString(5));
				user.setSecurityanswer(rs.getString(6));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static UserDetailsBeanModel authenticateUserSecurity(UserDetailsBeanModel user) {

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(
					"select userid, email, phone, userrole, securityquestion, securityanswer from userdetails where (email = ? and securityquestion = ? and securityanswer = ?)");

			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getSecurityquestion());
			stmt.setString(3, user.getSecurityanswer());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setUserrole(rs.getString(4));
				user.setSecurityquestion(rs.getString(5));
				user.setSecurityanswer(rs.getString(6));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static int changePassword(UserDetailsBeanModel user) {

		int i = 0;

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("update userdetails set password = ? where email = ?");

			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getEmail());

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

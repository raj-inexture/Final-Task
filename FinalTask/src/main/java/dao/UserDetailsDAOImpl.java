package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.UserDetailsBeanModel;
import util.DatabaseConnection;

public class UserDetailsDAOImpl implements UserDetailsDAOInterface {

	static Connection conn;

	public int nextKey() {

		int key = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

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

	public int addUser(UserDetailsBeanModel user) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(
					"insert into userdetails (userid, firstname, lastname, email, gender, dob, phone, password, profilephoto, userrole, securityquestion, securityanswer) values(?, ?, ?, ?, ?, str_to_date(?,'%d/%m/%Y'), ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, nextKey());
			stmt.setString(2, user.getFirstname());
			stmt.setString(3, user.getLastname());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getDob());
			stmt.setString(7, user.getPhone());
			stmt.setString(8, user.getPassword());
			stmt.setBinaryStream(9, user.getProfilephoto());
			stmt.setString(10, "User");
			stmt.setString(11, user.getSecurityquestion());
			stmt.setString(12, user.getSecurityanswer());

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

	public List<UserDetailsBeanModel> userEmails() {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			List<UserDetailsBeanModel> emailList = new LinkedList<UserDetailsBeanModel>();

			PreparedStatement stmt = conn.prepareStatement("select email, phone from userdetails");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserDetailsBeanModel user = new UserDetailsBeanModel();

				user.setEmail(rs.getString(1));
				user.setPhone(rs.getString(2));

				emailList.add(user);
			}

			return emailList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public UserDetailsBeanModel authenticateUser(UserDetailsBeanModel user) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

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

	public UserDetailsBeanModel authenticateUsername(UserDetailsBeanModel user) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

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

	public UserDetailsBeanModel authenticateUserSecurity(UserDetailsBeanModel user) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

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

	public int changePassword(UserDetailsBeanModel user) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

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

	public UserDetailsBeanModel viewUserDetails(UserDetailsBeanModel user) {

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("select * from userdetails where email = ?");

			stmt.setString(1, user.getEmail());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setPhone(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setProfilephoto(rs.getBinaryStream(9));
				user.setUserrole(rs.getString(10));
				user.setSecurityquestion(rs.getString(11));
				user.setSecurityanswer(rs.getString(12));

				return user;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<UserDetailsBeanModel> viewAllUserDetails(UserDetailsBeanModel users) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			List<UserDetailsBeanModel> userList = new LinkedList<UserDetailsBeanModel>();

			PreparedStatement stmt = conn.prepareStatement(
					"select userid, firstname, lastname, email, phone from userdetails where userrole = 'User'");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserDetailsBeanModel user = new UserDetailsBeanModel();

				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPhone(rs.getString(5));

				userList.add(user);
			}

			return userList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void deleteUser(UserDetailsBeanModel user) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement("delete from userdetails where userid = ?");

			stmt.setInt(1, user.getUserid());

			i = stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<UserDetailsBeanModel> viewAllUserProfileData(UserDetailsBeanModel user) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			List<UserDetailsBeanModel> userList = new LinkedList<UserDetailsBeanModel>();

			PreparedStatement stmt = conn.prepareStatement("select * from userdetails where email = ?");

			stmt.setString(1, user.getEmail());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setGender(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setPhone(rs.getString(7));
				user.setPassword(rs.getString(8));
				user.setProfilephoto(rs.getBinaryStream(9));
				user.setUserrole(rs.getString(10));
				user.setSecurityquestion(rs.getString(11));
				user.setSecurityanswer(rs.getString(12));

				userList.add(user);
			}

			return userList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int updateUser(UserDetailsBeanModel user) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(
					"update userdetails set firstname = ?, lastname = ?, gender = ?, dob = str_to_date(?,'%d/%m/%Y'), password = ?, securityquestion = ?, securityanswer = ? where email = ?");

			stmt.setString(1, user.getFirstname());
			stmt.setString(2, user.getLastname());
			stmt.setString(3, user.getGender());
			stmt.setString(4, user.getDob());
			stmt.setString(5, user.getPassword());
			stmt.setString(6, user.getSecurityquestion());
			stmt.setString(7, user.getSecurityanswer());
			stmt.setString(8, user.getEmail());

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

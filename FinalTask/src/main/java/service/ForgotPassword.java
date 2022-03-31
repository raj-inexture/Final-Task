package service;

import dao.UserDetailsDAO;
import model.UserDetailsBeanModel;

public class ForgotPassword {

	public static UserDetailsBeanModel authenticateUsername(UserDetailsBeanModel user) {

		user = UserDetailsDAO.authenticateUsername(user);

		return user;
	}

	public static UserDetailsBeanModel authenticateUserSecurity(UserDetailsBeanModel user) {

		user = UserDetailsDAO.authenticateUserSecurity(user);

		return user;
	}

	public static int changePassword(UserDetailsBeanModel user) {

		int result = UserDetailsDAO.changePassword(user);

		return result;
	}
}

package service;

import dao.UserDetailsDAOImpl;
import dao.UserDetailsDAOInterface;
import model.UserDetailsBeanModel;

public class ForgotPasswordImpl implements ForgotPasswordInterface {

	public UserDetailsBeanModel authenticateUsername(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		user = userDetails.authenticateUsername(user);

		return user;

	}

	public UserDetailsBeanModel authenticateUserSecurity(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		user = userDetails.authenticateUserSecurity(user);

		return user;

	}

	public int changePassword(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		int result = userDetails.changePassword(user);

		return result;

	}
}

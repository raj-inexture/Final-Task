package service;

import dao.UserDetailsDAOImpl;
import dao.UserDetailsDAOInterface;
import model.UserDetailsBeanModel;

public class AdminUserLoginImpl implements AdminUserLoginInterface {

	public int registerUser(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		int result = userDetails.addUser(user);

		return result;

	}

	public UserDetailsBeanModel authenticateUser(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		user = userDetails.authenticateUser(user);

		return user;

	}
}

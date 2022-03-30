package service;

import dao.UserDetailsDAO;
import model.UserDetailsBeanModel;

public class LoginUser {

	public static UserDetailsBeanModel authenticateUser(UserDetailsBeanModel user) {

		user = UserDetailsDAO.authenticateUser(user);

		return user;
	}
}

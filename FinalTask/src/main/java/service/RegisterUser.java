package service;

import dao.UserDetailsDAO;
import model.UserDetailsBeanModel;

public class RegisterUser {

	public static int registerUser(UserDetailsBeanModel user) {

		int result = UserDetailsDAO.addUser(user);

		return result;
	}
}

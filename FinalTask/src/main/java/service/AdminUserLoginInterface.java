package service;

import model.UserDetailsBeanModel;

public interface AdminUserLoginInterface {

	public UserDetailsBeanModel authenticateUser(UserDetailsBeanModel user);

}

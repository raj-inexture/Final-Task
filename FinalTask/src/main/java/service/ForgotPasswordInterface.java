package service;

import model.UserDetailsBeanModel;

public interface ForgotPasswordInterface {

	public UserDetailsBeanModel authenticateUsername(UserDetailsBeanModel user);

	public UserDetailsBeanModel authenticateUserSecurity(UserDetailsBeanModel user);

	public int changePassword(UserDetailsBeanModel user);

}

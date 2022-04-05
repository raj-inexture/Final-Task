package dao;

import java.util.List;

import model.UserDetailsBeanModel;

public interface UserDetailsDAOInterface {

	public int addUser(UserDetailsBeanModel user);

	public UserDetailsBeanModel authenticateUser(UserDetailsBeanModel user);

	public UserDetailsBeanModel authenticateUsername(UserDetailsBeanModel user);

	public UserDetailsBeanModel authenticateUserSecurity(UserDetailsBeanModel user);

	public int changePassword(UserDetailsBeanModel user);

	public UserDetailsBeanModel viewUserDetails(UserDetailsBeanModel user);

	public List<UserDetailsBeanModel> viewAllUserDetails(UserDetailsBeanModel users);

	public int deleteUser(UserDetailsBeanModel user);

}

package dao;

import java.util.List;

import model.UserDetailsBeanModel;

public interface UserDetailsDAOInterface {

	public int addUser(UserDetailsBeanModel user);

	public List<UserDetailsBeanModel> userEmails();

	public UserDetailsBeanModel authenticateUser(UserDetailsBeanModel user);

	public UserDetailsBeanModel authenticateUsername(UserDetailsBeanModel user);

	public UserDetailsBeanModel authenticateUserSecurity(UserDetailsBeanModel user);

	public int changePassword(UserDetailsBeanModel user);

	public UserDetailsBeanModel viewUserDetails(UserDetailsBeanModel user);

	public List<UserDetailsBeanModel> viewAllUserDetails(UserDetailsBeanModel users);

	public void deleteUser(UserDetailsBeanModel user);

	public List<UserDetailsBeanModel> viewAllUserProfileData(UserDetailsBeanModel user);

	public int updateUser(UserDetailsBeanModel user);

}

package service;

import java.util.List;

import model.AddressBeanModel;
import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;

public interface ViewUsersInterface {

	public UserDetailsBeanModel viewUserDetails(UserDetailsBeanModel user);

	public List<AddressBeanModel> viewUserAddress(int userid);

	public List<TechnologiesBeanModel> viewUserTechnology(int userid);

	public List<UserDetailsBeanModel> viewAllUserDetails(UserDetailsBeanModel user);

	public void deleteUser(UserDetailsBeanModel user);

	public List<UserDetailsBeanModel> viewUserData(UserDetailsBeanModel user);

}

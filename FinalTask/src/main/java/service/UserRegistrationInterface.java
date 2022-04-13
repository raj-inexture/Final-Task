package service;

import java.util.List;

import model.AddressBeanModel;
import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;

public interface UserRegistrationInterface {

	public int registerUser(UserDetailsBeanModel user);

	public int registerUserAddress(AddressBeanModel address);

	public int registerUserTechnologies(TechnologiesBeanModel technologies);

	public List<UserDetailsBeanModel> viewUserEmail();

}

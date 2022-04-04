package service;

import model.AddressBeanModel;
import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;

public interface UserRegistrationInterface {

	public int registerUser(UserDetailsBeanModel user);

	public int registerUserAddress(AddressBeanModel address);

	public int registerUserTechnologies(TechnologiesBeanModel technologies);

}

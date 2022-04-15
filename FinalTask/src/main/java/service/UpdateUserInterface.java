package service;

import model.AddressBeanModel;
import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;

public interface UpdateUserInterface {

	public int updateUser(UserDetailsBeanModel user);

//	public int deleteDuplicateAddress();

//	public int deleteDuplicateTechnology();

	public int updateUserAddress(AddressBeanModel address);

	public int deleteUserAddress(int id);

	public int deleteUserTechnologies(TechnologiesBeanModel technology);

}

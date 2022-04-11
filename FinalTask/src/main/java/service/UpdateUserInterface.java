package service;

import model.UserDetailsBeanModel;

public interface UpdateUserInterface {

	public int updateUser(UserDetailsBeanModel user);

	public int deleteDuplicateAddress();

	public int deleteDuplicateTechnology();

}

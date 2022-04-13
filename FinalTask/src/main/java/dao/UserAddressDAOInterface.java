package dao;

import java.util.List;

import model.AddressBeanModel;

public interface UserAddressDAOInterface {

	public int addUserAddress(AddressBeanModel address);

	public List<AddressBeanModel> viewUserAddress(int userid);

//	public int deleteDuplicateAddress();

	public int updateUserAddress(AddressBeanModel address);

	public int deleteUserAddress(AddressBeanModel address);

}

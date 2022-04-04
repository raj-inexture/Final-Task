package dao;

import java.util.List;

import model.AddressBeanModel;

public interface UserAddressDAOInterface {

	public int addUserAddress(AddressBeanModel address);

	public List<AddressBeanModel> viewUserAddress(int userid);

}

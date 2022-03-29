package service;

import dao.UserAddressDAO;
import model.AddressBeanModel;

public class RegisterUserAddress {

	public static int registerUserAddress(AddressBeanModel address) {

		int result = UserAddressDAO.addUserAddress(address);

		return result;
	}
}

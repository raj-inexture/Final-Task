package service;

import dao.UserAddressDAOImpl;
import dao.UserAddressDAOInterface;
import dao.UserDetailsDAOImpl;
import dao.UserDetailsDAOInterface;
import dao.UserTechnologiesDAOImpl;
import dao.UserTechnologiesDAOInterface;
import model.UserDetailsBeanModel;

public class UpdateUserImpl implements UpdateUserInterface {

	public int updateUser(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		int result = userDetails.updateUser(user);

		return result;

	}

	public int deleteDuplicateAddress() {

		UserAddressDAOInterface userAddress = new UserAddressDAOImpl();

		int result = userAddress.deleteDuplicateAddress();

		return result;

	}

	public int deleteDuplicateTechnology() {

		UserTechnologiesDAOInterface userTechnology = new UserTechnologiesDAOImpl();

		int result = userTechnology.deleteDuplicateTechnology();

		return result;

	}

}

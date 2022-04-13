package service;

import java.util.LinkedList;
import java.util.List;

import dao.UserAddressDAOImpl;
import dao.UserAddressDAOInterface;
import dao.UserDetailsDAOImpl;
import dao.UserDetailsDAOInterface;
import dao.UserTechnologiesDAOImpl;
import dao.UserTechnologiesDAOInterface;
import model.AddressBeanModel;
import model.TechnologiesBeanModel;
import model.UserDetailsBeanModel;

public class UserRegistrationImpl implements UserRegistrationInterface {

	@Override
	public int registerUser(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		int result = userDetails.addUser(user);

		return result;

	}

	@Override
	public int registerUserAddress(AddressBeanModel address) {

		UserAddressDAOInterface userAddress = new UserAddressDAOImpl();

		int result = userAddress.addUserAddress(address);

		return result;

	}

	@Override
	public int registerUserTechnologies(TechnologiesBeanModel technologies) {

		UserTechnologiesDAOInterface userTechnologies = new UserTechnologiesDAOImpl();

		int result = userTechnologies.addUserTechnology(technologies);

		return result;

	}

	public List<UserDetailsBeanModel> viewUserEmail() {

		UserDetailsDAOInterface userEmail = new UserDetailsDAOImpl();

		List<UserDetailsBeanModel> listEmail = new LinkedList<UserDetailsBeanModel>();

		listEmail = userEmail.userEmails();

		return listEmail;

	}

}

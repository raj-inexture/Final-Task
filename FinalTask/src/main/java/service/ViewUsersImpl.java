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

public class ViewUsersImpl implements ViewUsersInterface {

	public UserDetailsBeanModel viewUserDetails(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		user = userDetails.viewUserDetails(user);

		return user;

	}

	public List<AddressBeanModel> viewUserAddress(int userid) {

		UserAddressDAOInterface userAddress = new UserAddressDAOImpl();

		List<AddressBeanModel> listAddress = new LinkedList<AddressBeanModel>();

		listAddress = userAddress.viewUserAddress(userid);

		return listAddress;

	}

	public List<TechnologiesBeanModel> viewUserTechnology(int userid) {

		UserTechnologiesDAOInterface userTechnology = new UserTechnologiesDAOImpl();

		List<TechnologiesBeanModel> listTechnology = new LinkedList<TechnologiesBeanModel>();

		listTechnology = userTechnology.viewUserTechnology(userid);

		return listTechnology;

	}

	public List<UserDetailsBeanModel> viewAllUserDetails(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		List<UserDetailsBeanModel> listUsers = new LinkedList<UserDetailsBeanModel>();

		listUsers = userDetails.viewAllUserDetails(user);

		return listUsers;

	}

	public void deleteUser(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userDetails = new UserDetailsDAOImpl();

		userDetails.deleteUser(user);

	}

	public List<UserDetailsBeanModel> viewUserData(UserDetailsBeanModel user) {

		UserDetailsDAOInterface userList = new UserDetailsDAOImpl();

		List<UserDetailsBeanModel> listUser = new LinkedList<UserDetailsBeanModel>();

		listUser = userList.viewAllUserProfileData(user);

		return listUser;

	}
}

package service;

import dao.UserTechnologiesDAO;
import model.TechnologiesBeanModel;

public class RegisterUserTechnologies {

	public static int registerUserTechnology(TechnologiesBeanModel technology) {

		int result = UserTechnologiesDAO.addUserTechnology(technology);

		return result;
	}
}

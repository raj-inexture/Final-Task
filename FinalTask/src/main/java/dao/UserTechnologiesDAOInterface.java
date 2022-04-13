package dao;

import java.util.List;

import model.TechnologiesBeanModel;

public interface UserTechnologiesDAOInterface {

	public int addUserTechnology(TechnologiesBeanModel technology);

	public List<TechnologiesBeanModel> viewUserTechnology(int userid);

//	public int deleteDuplicateTechnology();

	public int deleteUserTechnologies(TechnologiesBeanModel technology);

}

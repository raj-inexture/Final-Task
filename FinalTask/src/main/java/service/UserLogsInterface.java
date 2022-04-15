package service;

import java.util.List;

import model.UserLogsBeanModel;

public interface UserLogsInterface {

	public void userLogs();

	public List<UserLogsBeanModel> viewAllUserLogs();

	public int addStartStamp(UserLogsBeanModel userlogs);

	public UserLogsBeanModel setID(UserLogsBeanModel userlogs);

	public int addEndStamp(UserLogsBeanModel userlogs);
}

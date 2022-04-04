package service;

import model.UserLogsBeanModel;

public interface UserLogsInterface {

	public void userLogs();

	public int addStartStamp(UserLogsBeanModel userlogs);

	public UserLogsBeanModel setID(UserLogsBeanModel userlogs);

	public int addEndStamp(UserLogsBeanModel userlogs);
}

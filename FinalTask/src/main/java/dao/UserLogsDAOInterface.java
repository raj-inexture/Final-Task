package dao;

import model.UserLogsBeanModel;

public interface UserLogsDAOInterface {

	public void userLogs();

	public int addStartStamp(UserLogsBeanModel userlogs);

	public UserLogsBeanModel setID(UserLogsBeanModel userlogs);

	public int addEndStamp(UserLogsBeanModel userlogs);

}

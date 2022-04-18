package dao;

import java.util.List;

import model.UserLogsBeanModel;

public interface UserLogsDAOInterface {

	public List<UserLogsBeanModel> viewAllUserLogs();

	public int addStartStamp(UserLogsBeanModel userlogs);

	public UserLogsBeanModel setID(UserLogsBeanModel userlogs);

	public int addEndStamp(UserLogsBeanModel userlogs);

	public List<UserLogsBeanModel> fetchUserLogs(String startdate, String enddate, String starttime, String endtime);

}

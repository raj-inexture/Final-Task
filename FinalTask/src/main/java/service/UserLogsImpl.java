package service;

import dao.UserLogsDAOImpl;
import dao.UserLogsDAOInterface;
import model.UserLogsBeanModel;

public class UserLogsImpl implements UserLogsInterface {

	public void userLogs() {

		UserLogsDAOInterface userlogs = new UserLogsDAOImpl();

		userlogs.userLogs();

	}

	public int addStartStamp(UserLogsBeanModel userlogs) {

		UserLogsDAOInterface userLogs = new UserLogsDAOImpl();

		int result = userLogs.addStartStamp(userlogs);

		return result;

	}

	public UserLogsBeanModel setID(UserLogsBeanModel userlogs) {

		UserLogsDAOInterface userLogs = new UserLogsDAOImpl();

		userlogs = userLogs.setID(userlogs);

		return userlogs;

	}

	public int addEndStamp(UserLogsBeanModel userlogs) {

		UserLogsDAOInterface userLogs = new UserLogsDAOImpl();

		int result = userLogs.addEndStamp(userlogs);

		return result;

	}

}

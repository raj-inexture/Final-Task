package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.TechnologiesBeanModel;
import util.DatabaseConnection;

public class UserTechnologiesDAO {

	public static int addUserTechnology(TechnologiesBeanModel technology) {

		int i = 0;

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn
					.prepareStatement("insert into technologies (userid, technology) values(?, ?)");

			stmt.setInt(1, technology.getUserid());
			stmt.setString(2, technology.getTechnology());

			i = stmt.executeUpdate();

			if (i != 0) {
				return i;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}

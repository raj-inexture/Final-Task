package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.TechnologiesBeanModel;
import util.DatabaseConnection;

public class UserTechnologiesDAOImpl implements UserTechnologiesDAOInterface {

	static Connection conn;

	public int addUserTechnology(TechnologiesBeanModel technology) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

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

	public List<TechnologiesBeanModel> viewUserTechnology(int userid) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			List<TechnologiesBeanModel> technologyList = new LinkedList<TechnologiesBeanModel>();

			PreparedStatement stmt = conn.prepareStatement("select * from technologies where userid = ?");

			stmt.setInt(1, userid);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				TechnologiesBeanModel technology = new TechnologiesBeanModel();

				technology.setId(rs.getInt(1));
				technology.setUserid(rs.getInt(2));
				technology.setTechnology(rs.getString(3));

				technologyList.add(technology);
			}

			return technologyList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

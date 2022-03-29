package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.AddressBeanModel;
import util.DatabaseConnection;

public class UserAddressDAO {

	public static int addUserAddress(AddressBeanModel address) {

		int i = 0;

		try {
			Connection conn = DatabaseConnection.getInstance().getConnection();

			PreparedStatement stmt = conn.prepareStatement(
					"insert into address (userid, addressline1, addressline2, city, state, zipcode) values(?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, address.getUserid());
			stmt.setString(2, address.getAddressline1());
			stmt.setString(3, address.getAddressline2());
			stmt.setString(4, address.getCity());
			stmt.setString(5, address.getState());
			stmt.setString(6, address.getZipcode());

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

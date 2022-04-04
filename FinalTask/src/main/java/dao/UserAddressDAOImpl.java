package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.AddressBeanModel;
import util.DatabaseConnection;

public class UserAddressDAOImpl implements UserAddressDAOInterface {

	static Connection conn;

	public int addUserAddress(AddressBeanModel address) {

		int i = 0;

		try {
			conn = DatabaseConnection.getInstance().getConnection();

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

	public List<AddressBeanModel> viewUserAddress(int userid) {

		try {
			conn = DatabaseConnection.getInstance().getConnection();

			List<AddressBeanModel> addressList = new LinkedList<AddressBeanModel>();

			PreparedStatement stmt = conn.prepareStatement("select * from address where userid = ?");

			stmt.setInt(1, userid);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				AddressBeanModel address = new AddressBeanModel();

				address.setId(rs.getInt(1));
				address.setUserid(rs.getInt(2));
				address.setAddressline1(rs.getString(3));
				address.setAddressline2(rs.getString(4));
				address.setCity(rs.getString(5));
				address.setState(rs.getString(6));
				address.setZipcode(rs.getString(7));

				addressList.add(address);
			}

			return addressList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

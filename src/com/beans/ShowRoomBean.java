package com.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.models.ShowRoom;
import com.mysql.jdbc.Statement;

public class ShowRoomBean {

	private Connection conn;

	public ShowRoomBean() {
		conn = DBConnection.getActiveConnection();
	}

	private ShowRoom parseShowRoom(ResultSet rs) throws SQLException {

		ShowRoom showRoom = new ShowRoom();

		showRoom.setShowRoomID(rs.getInt("showroom_id"));
		showRoom.setName(rs.getString("name"));
		showRoom.setDescription(rs.getString("desc"));
		showRoom.setAddress(rs.getString("address"));
		showRoom.setLocation(rs.getString("location"));
		showRoom.setPhone(rs.getString("phone"));
		showRoom.setImage(rs.getString("image"));

		return showRoom;
	}

	public ArrayList<ShowRoom> getShowRooms() {

		try {
			String sql = "SELECT * FROM showroom";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			ArrayList<ShowRoom> showrooms = new ArrayList<ShowRoom>();

			while (rs.next())
				showrooms.add(parseShowRoom(rs));

			return showrooms;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ShowRoom addShowRoom(ShowRoom showroom) {
		try {
			String sql = "INSERT INTO `showroom` (`name`, `desc`, `address`, `location`,"
					+ " `phone`, `image`) VALUES (?,?,?,?,?,?);";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, showroom.getName());
			stmt.setString(2, showroom.getDescription());
			stmt.setString(3, showroom.getAddress());
			stmt.setString(4, showroom.getLocation());
			stmt.setString(5, showroom.getPhone());
			stmt.setString(6, showroom.getImage());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				showroom.setShowRoomID(rs.getInt(1));

				return showroom;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String updateShowRoom(ShowRoom showroom) {
		try {
			String sql = "UPDATE `showroom` SET `name`=?,`desc`=?,`address`=?,"
					+ "`location`=?,`phone`=?,`image`=? WHERE `showroom_id`=?";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, showroom.getName());
			stmt.setString(2, showroom.getDescription());
			stmt.setString(3, showroom.getAddress());
			stmt.setString(4, showroom.getLocation());
			stmt.setString(5, showroom.getPhone());
			stmt.setString(6, showroom.getImage());
			stmt.setInt(7, showroom.getShowRoomID());

			int nRows = stmt.executeUpdate();
			if (nRows == 1)
				return "true";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "false";
	}

	public String deleteShowRoom(int showroomID) {
		try {
			String sql = "DELETE FROM `showroom` WHERE `showroom_id` = ?";

			PreparedStatement stmt;

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, showroomID);

			int nRows = stmt.executeUpdate();
			if (nRows == 1)
				return "true";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "false";
	}

	public ArrayList<ShowRoom> searchShowRooms(String name) {
		try {
			String sql = "SELECT * FROM showroom WHERE name LIKE ?";

			PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();

			ArrayList<ShowRoom> showrooms = new ArrayList<ShowRoom>();

			while (rs.next())
				showrooms.add(parseShowRoom(rs));

			return showrooms;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}

package com.teamecho.chacha.favorite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teamecho.chacha.db.DataSource;
import com.teamecho.chacha.db.NamingService;
import com.teamecho.chacha.favorite.domain.Favorite;

public class FavoriteDao {
	private DataSource ds;

	public FavoriteDao() {
		NamingService namingService = NamingService.getInstance();
		ds = (DataSource) namingService.getAttribute("dataSource");
	}

	public void addFavo(Favorite fv) {
		String sql = "INSERT INTO Favorite(uid, pid) "
				+ " VALUES (?, ?);";
		try {
			Connection con = ds.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setLong(1, fv.getUid());
			psmt.setLong(2, fv.getPid());
			psmt.executeUpdate();
			System.out.println("INSTERTED...");
			ds.close(psmt, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Favorite> findFavo() {
		String sql = "SELECT * FROM Favorite";
		List<Favorite> fvList = new ArrayList<Favorite>();

		try {
			Connection con = ds.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Favorite fv = new Favorite();
				fv.setUid(rs.getLong("uid"));
				fv.setPid(rs.getLong("pid"));
				fvList.add(fv);
			}
			System.out.println("SELECTED...");
			ds.close(rs, psmt, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fvList;
	}

	public void deleFavo(Favorite fv) {
		String sql = "DELETE FROM Favorite WHERE pid = ?;";

		try {
			Connection con = ds.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setLong(1, fv.getUid());
			psmt.setLong(2, fv.getPid());
			psmt.executeUpdate();
			System.out.println("DELETE...");
			ds.close(psmt, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

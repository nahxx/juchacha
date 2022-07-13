package com.teamecho.chacha.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.teamecho.chacha.db.DataSource;
import com.teamecho.chacha.db.NamingService;
import com.teamecho.chacha.user.domain.User;

public class UserDao {
	DataSource dataSource = null;
	
	public UserDao() {
		NamingService namingService = NamingService.getInstance();
		dataSource = (DataSource)namingService.getAttribute("dataSource");
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO UserInfo(userId, passwd, userName, userPhone, licenseNumber) VALUES(?,?,?,?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserPhone());
			pstmt.setString(5, user.getLicenseNumber());
			
			pstmt.executeUpdate();
			dataSource.close(pstmt, con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Map<String,String> isValidUser(String userId, String passwd) {
		String sql = "SELECT userId, passwd FROM UserInfo WHERE userId=?";
		Map<String,String> userIdPW = new HashMap<String, String>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					userIdPW.put("userId", rs.getString("userId"));
					userIdPW.put("passwd", rs.getString("passwd"));
				}
			}finally {
				dataSource.close(rs, pstmt, con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return userIdPW;
	}
}

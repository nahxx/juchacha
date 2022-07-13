package com.teamecho.chacha.parking.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.teamecho.chacha.db.*;
import com.teamecho.chacha.parking.domain.ParkingLot;

public class ParkingLotDao {
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	public ParkingLotDao() {
		
	}
	/**
	 * 모든 주차장 정보 객체를 찾는 함수
	 * @작성자 : 박동근
	 * @return
	 */
	public List<ParkingLot> findAllParkingLot(){	
		String sql = "SELECT * FROM parkingLot";
		List<ParkingLot> parkingdotList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ParkingLot p = new ParkingLot();
					p.setPid(rs.getLong("pid"));
					p.setParkingCode(rs.getString("parkingCode"));
					p.setParkingName(rs.getString("parkingName"));
					p.setParkingAddr(rs.getString("parkingAddr"));
					p.setParkingTel(rs.getString("parkingTel"));
					p.setTimeCost(rs.getDouble("timeCost"));
					p.setDayCost(rs.getDouble("dayCost"));
					p.setMonthCost(rs.getDouble("monthCost"));
					p.setParkingSpace(rs.getInt("parkingSpace"));
					p.setPointX(rs.getDouble("pointX"));
					p.setPointY(rs.getDouble("pointY"));
					
					parkingdotList.add(p);
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return parkingdotList;
	}
	
	public ParkingLot findParkingLotByPoint(double pointX, double pointY){	
		String sql = "SELECT * FROM parkingLot WHERE pointx =? AND pointy =?";
		ParkingLot parkingLot = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1,pointX);
				pstmt.setDouble(2,pointY);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					parkingLot = new ParkingLot();
					parkingLot.setPid(rs.getLong("pid"));
					parkingLot.setParkingCode(rs.getString("parkingCode"));
					parkingLot.setParkingName(rs.getString("parkingName"));
					parkingLot.setParkingAddr(rs.getString("parkingAddr"));
					parkingLot.setParkingTel(rs.getString("parkingTel"));
					parkingLot.setTimeCost(rs.getDouble("timeCost"));
					parkingLot.setDayCost(rs.getDouble("dayCost"));
					parkingLot.setMonthCost(rs.getDouble("monthCost"));
					parkingLot.setParkingSpace(rs.getInt("parkingSpace"));
					parkingLot.setPointX(rs.getDouble("pointX"));
					parkingLot.setPointY(rs.getDouble("pointY"));
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return parkingLot;
	}
	
	public ParkingLot findParkingLotByCode(String parkingcode){	
		String sql = "SELECT * FROM parkingLot WHERE parkingCode =?";
		ParkingLot parkingLot = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,parkingcode);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					parkingLot = new ParkingLot();
					parkingLot.setPid(rs.getLong("pid"));
					parkingLot.setParkingCode(rs.getString("parkingCode"));
					parkingLot.setParkingName(rs.getString("parkingName"));
					parkingLot.setParkingAddr(rs.getString("parkingAddr"));
					parkingLot.setParkingTel(rs.getString("parkingTel"));
					parkingLot.setTimeCost(rs.getDouble("timeCost"));
					parkingLot.setDayCost(rs.getDouble("dayCost"));
					parkingLot.setMonthCost(rs.getDouble("monthCost"));
					parkingLot.setParkingSpace(rs.getInt("parkingSpace"));
					parkingLot.setPointX(rs.getDouble("pointX"));
					parkingLot.setPointY(rs.getDouble("pointY"));
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return parkingLot;
	}
	
//	public boolean isValidUser(String userId, String passwd) {
//		String sql = "SELECT * FROM userinfo WHERE userid = ? and passwd = ?";
//		int i = 0;
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
//				con = ds.getConnection();
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1,userId);
//				pstmt.setString(2,passwd);
//				rs = pstmt.executeQuery();
//				while(rs.next()) {
//					i++;
//				}
//			}finally {
//				ds.close(rs, pstmt, con);
//			}
//		}catch(SQLException e) {  
//			e.printStackTrace();
//		}
//		if (i > 0) {
//			return true;
//		}else {
//			return false;
//		}
//	}
//	
//	public void addUser(User user) {
//		String sql = "INSERT INTO UserInfo(userid, passwd, username, ssn, email, addr )  VAlUES (?, ?, ?, ?, ?, ?)";
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,user.getUserId());
//			pstmt.setString(2,user.getPasswd());
//			pstmt.setString(3,user.getUserName());
//			pstmt.setString(4,user.getSsn());
//			pstmt.setString(5,user.getEmail());
//			pstmt.setString(6,user.getAddr());
//			pstmt.executeUpdate();
//			ds.close(pstmt, con);
//			System.out.println("INSERTED....");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	

//	
//	public User findUserByName(String ssn){
//		String sql = "SELECT * FROM UserInfo WHERE username = ?";
//		User c = null;
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
//				con = ds.getConnection();
//				pstmt = con.prepareStatement(sql);
//				pstmt.setString(1,ssn);
//				rs = pstmt.executeQuery();
//				if(rs.next()) {
//					c = new User();
//					c.setUserId(rs.getString("userId"));
//					c.setPasswd(rs.getString("passwd"));
//					c.setUserName(rs.getString("username"));
//					c.setSsn(rs.getString("ssn"));
//					c.setEmail(rs.getString("email"));
//					c.setAddr(rs.getString("addr"));
//				}
//
//			}finally {
//				ds.close(rs, pstmt, con);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return c;
//	}
//	public void updateUser(User user) {
//		String sql = "UPDATE UserInfo SET passwd =?, username =?, ssn =?, email =?, addr =?  WHERE userid = ?";
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,user.getPasswd());
//			pstmt.setString(2,user.getUserName());
//			pstmt.setString(3,user.getSsn());
//			pstmt.setString(4,user.getEmail());
//			pstmt.setString(5,user.getAddr());
//			pstmt.setString(6,user.getUserId());
//			pstmt.executeUpdate();
//			ds.close(pstmt, con);
//			System.out.println("UPDATE....");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}

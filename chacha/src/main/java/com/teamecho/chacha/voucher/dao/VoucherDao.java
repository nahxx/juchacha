package com.teamecho.chacha.voucher.dao;

import java.sql.*;
import java.util.*;
import com.teamecho.chacha.db.DataSource;
import com.teamecho.chacha.db.NamingService;
import com.teamecho.chacha.voucher.domain.Voucher;

public class VoucherDao {
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	public VoucherDao() {
		
	}
	
//	//등록
//	public void addVoucher(Voucher voucher) {
//		String sql = "INSERT INTO Voucher(vType, buyTime)  VAlUES (?, ?)";
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,voucher.getvType());
//			pstmt.setString(2,voucher.getBuyTime());
//			pstmt.executeUpdate();
//			ds.close(pstmt, con);
//			System.out.println("INSERTED....");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//전체 주차권 가져오기
	public List<Voucher> findAllVouchers(){	
		String sql = "SELECT * FROM voucher";
		List<Voucher> voucherList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Voucher v = new Voucher();
					v.setvType(rs.getString("vType"));
					v.setBuyTime(rs.getString("buyTime"));
					voucherList.add(v);
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return voucherList;
	}
	
	//Voucher 내역 
	public Voucher findVoucherByvType(String vType){
		String sql = "SELECT * FROM Voucher WHERE vType = ?";
		Voucher v = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,vType);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					v = new Voucher();
					v.setvType(rs.getString("vType"));
					v.setBuyTime(rs.getString("buyTime"));
				}

			}finally {
				ds.close(rs, pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
//	//업데이트(수정,추가 변경)
//	public void updateVoucher(Voucher Voucher) {
//		String sql = "UPDATE Voucher SET vType =?, buyTime =? WHERE vid = ?";
//		try {
//			Connection con = null;
//			PreparedStatement pstmt = null;
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1,Voucher.getvType());
//			pstmt.setString(2,Voucher.getBuyTime());
//			pstmt.executeUpdate();
//			ds.close(pstmt, con);
//			System.out.println("UPDATE....");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}

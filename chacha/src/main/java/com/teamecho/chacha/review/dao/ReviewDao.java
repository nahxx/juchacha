//package com.teamecho.chacha.review.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//import com.teamecho.chacha.db.DataSource;
//import com.teamecho.chacha.db.NamingService;
//import com.teamecho.chacha.review.domain.Review;
//
//public class ReviewDao {
//	
//	private DataSource ds;
//	
//	public ReviewDao() {
//		NamingService namingService = NamingService.getInstance();
//		ds = (DataSource)namingService.getAttribute("dataSource");
//	}
//	
//	public void addReview(Review review) {
//		String sql = "INSERT INTO Review (uid, pid, content, star_rating)" 
//				+ " VALUES (?, ?, ?, ?);";
//		
//		try {
//			Connection con = ds.getConnection();
//			PreparedStatement psmt = con.prepareStatement(sql);
//			psmt.setLong(1, 1);
//			psmt.setLong(2, 1);
//			psmt.setString(3, review.getContent());
//			System.out.println(review.getContent());
//			psmt.setInt(4, review.getStar_rating());
//			System.out.println(review.getStar_rating());
//			psmt.executeUpdate();
//			System.out.println("INSTERTED...");
//			ds.close(psmt, con);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//}

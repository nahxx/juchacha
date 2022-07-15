package com.teamecho.chacha.voucher.dao;

import java.sql.*;
import java.util.*;
import com.teamecho.chacha.db.DataSource;
import com.teamecho.chacha.db.NamingService;
import com.teamecho.chacha.voucher.domain.VoucherUse;

public class VoucherUseDao {
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	public VoucherUseDao() {
		
	}

	public void addVoucherUse(List<VoucherUse> voucherUseList) {
		for(VoucherUse voucherUse : voucherUseList) {
			String sql = "INSERT INTO Voucher_Use(useTime, uid, vid)  VAlUES (?, ?, ?)";
			try {
				Connection con = null;
				PreparedStatement pstmt = null;
				con = ds.getConnection();
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1,voucherUse.getUseTime());
					pstmt.setLong(2,voucherUse.getUid());
					pstmt.setLong(3,voucherUse.getVid());
					pstmt.executeUpdate();
				}finally {
					System.out.println("INSERTED....");
					ds.close(pstmt, con);
				}	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

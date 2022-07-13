package com.teamecho.chacha.reservation.dao;

import com.teamecho.chacha.db.DataSource;
import com.teamecho.chacha.db.NamingService;

public class ReservationDao {
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	
}

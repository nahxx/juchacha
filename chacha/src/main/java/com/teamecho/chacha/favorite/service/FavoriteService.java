package com.teamecho.chacha.favorite.service;

import java.util.List;

import com.teamecho.chacha.favorite.dao.FavoriteDao;
import com.teamecho.chacha.favorite.domain.Favorite;
import com.teamecho.chacha.parking.dao.ParkingLotDao;
import com.teamecho.chacha.parking.domain.ParkingLot;
import com.teamecho.chacha.user.dao.UserDao;

public class FavoriteService {
	private static FavoriteService service = new FavoriteService();
	private FavoriteDao dao = new FavoriteDao();
	private UserDao userdao = new UserDao();
	private ParkingLotDao pdao = new ParkingLotDao();
	
	public FavoriteService(FavoriteDao dao) {
		this.dao = dao;
	}

	public FavoriteService() {
		
	}
	
	public static FavoriteService getInstance() {
		return service;
	}
	
	public void addFavo(Favorite fv) {
		dao.addFavo(fv);
	}
	
	public List<Favorite> getAllFavo(){
		return dao.findFavo();
	}
	
	public void deleFavo(Favorite fv) {
		dao.deleFavo(fv);
	}
	
	public long findUIdByUserId(String userId) {
		return userdao.findUIdByUserId(userId);
	}
	
	public ParkingLot getParkingLotByPid(long pid) {
		return pdao.findParkingLotByPid(pid);
	}

}

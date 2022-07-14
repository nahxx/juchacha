package com.teamecho.chacha.favorite.service;

import java.util.List;

import com.teamecho.chacha.favorite.dao.FavoriteDao;
import com.teamecho.chacha.favorite.domain.Favorite;

public class FavoriteService {
	private FavoriteDao dao = new FavoriteDao();
	
	public FavoriteService(FavoriteDao dao) {
		this.dao = dao;
	}

	public FavoriteService() {
		dao = new FavoriteDao();
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
	
	public boolean isValidPid(Long pid) {
		return dao.isValidPid(pid);
	}
}

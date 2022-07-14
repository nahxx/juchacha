package com.teamecho.chacha.parking.service;

import java.util.List;

import com.teamecho.chacha.parking.dao.ParkingLotDao;
import com.teamecho.chacha.parking.domain.ParkingLot;

public class ParkingLotService {
	private static final ParkingLotService parkingLotService = new ParkingLotService();
	private ParkingLotDao parkingLotDao;
	
	private ParkingLotService() {
		parkingLotDao = new ParkingLotDao();
	}
	
	public static ParkingLotService getInstance() {
		return parkingLotService;
	}
	public List<ParkingLot> findAllParkingLot() {
		return parkingLotDao.findAllParkingLot();
	}
	
	public ParkingLot findParkingLotByPoint(double pointX, double pointY) {
		return parkingLotDao.findParkingLotByPoint(pointX, pointY);
	}
	
	public ParkingLot findParkingLotByCode(String parkingcode) {
		return parkingLotDao.findParkingLotByCode(parkingcode);
	}
	public int getParkingLotSpaces(double pointX, double pointY) {
		return parkingLotDao.getParkingLotSpaces(pointX, pointY);
	}
	
	public ParkingLot findParkingLotByPid(Long pid) {
		return parkingLotDao.findParkingLotByPid(pid);
	}
}

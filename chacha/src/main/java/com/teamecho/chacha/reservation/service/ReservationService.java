package com.teamecho.chacha.reservation.service;

import java.util.ArrayList;
import java.util.List;

import com.teamecho.chacha.parking.domain.ParkingLot;
import com.teamecho.chacha.parking.service.ParkingLotService;
import com.teamecho.chacha.reservation.dao.ReservationDao;
import com.teamecho.chacha.reservation.domain.Reservation;

public class ReservationService {
	private static ReservationService service = new ReservationService();
	private ParkingLotService pService = ParkingLotService.getInstance();
	ReservationDao rDao = new ReservationDao();
	
	private ReservationService() {
		
	}
	
	/**
	 * 싱글톤 객체 얻는 메소드
	 * @return reservationService 객체
	 */
	public static ReservationService getInstance() {
		return service;
	}
	
	/**
	 * 좌표로 주차장 객체 얻는 메소드
	 * @param pointX
	 * @param pointY
	 * @return
	 */
	public ParkingLot getParkingLotByCode(String parkingcode) {
		return pService.findParkingLotByCode(parkingcode);
	}
	
	public ParkingLot getParkingLotByPid(long pid) {
		return pService.findParkingLotByPid(pid);
	}
	
	/**
	 * 예약 추가하는 메소드
	 * @param rez
	 */
	public void addReservation(Reservation rez) {
		rDao.addReservation(rez);
	}
	
	/**
	 * 예약리스트 얻는 메소드
	 * @return
	 */
	public List<Reservation> getReservationListByUid(long uid) {
		return rDao.findReservationListByUid(uid);
	}
}

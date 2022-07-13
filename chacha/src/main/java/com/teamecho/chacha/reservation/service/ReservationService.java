package com.teamecho.chacha.reservation.service;

import java.util.ArrayList;
import java.util.List;

import com.teamecho.chacha.reservation.domain.Reservation;

public class ReservationService {
	private static ReservationService service = new ReservationService();
	
	private ReservationService() {
		
	}
	
	/**
	 * 싱글톤 객체 얻는 메소드
	 * @return reservationService 객체
	 */
	public ReservationService getInstance() {
		return service;
	}
	
	/*
	 * 좌표x, y로 주차장객체 받아오는 메소드 필요
	 */
	
	/**
	 * 예약 추가하는 메소드
	 * @param rez
	 */
	public void addReservation(Reservation rez) {
		// 예약dao의 reservation 추가하는 메소드 호출
	}
	
	/**
	 * 예약리스트 얻는 메소드
	 * @return
	 */
	public List<Reservation> getReservationList(long uid) {
		List<Reservation> rezList = new ArrayList<>();
		// 예약 dao의 reservation리스트 받아오는 메소드 호출하여 리스트 객체 rezList에 추가
		return rezList;
	}
}

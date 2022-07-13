package com.teamecho.chacha.reservation.domain;

import java.util.Date;

/**
 * 예약 클래스
 * @author knh
 *
 */
public class Reservation {
	private long rid;
	private Date start_time;
	private Date end_time;
	private int cost;
	private String voucher_use;
	private long uid;
	private long pid;
	private static Reservation reservation = new Reservation();
	
	private Reservation() {
		
	}
	
	/**
	 * 싱글톤 객체 얻는 메소드
	 * @return reservation객체
	 */
	public Reservation getInstance() {
		return reservation;
	}

	public long getRid() {
		return rid;
	}

	public void setRid(long rid) {
		this.rid = rid;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getVoucher_use() {
		return voucher_use;
	}

	public void setVoucher_use(String voucher_use) {
		this.voucher_use = voucher_use;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}

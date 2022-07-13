package com.teamecho.chacha.reservation.domain;

import java.util.Date;

/**
 * 예약 클래스
 * @author 김나혜
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

	public Reservation() {
		
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
	
}

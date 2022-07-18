package com.teamecho.chacha.voucher.domain;

import java.sql.Timestamp;

public class Voucher {
	private long vid; //voucher 키값
	private String vType; // voucher의 타입 (ex: 시간당, 종일권, 정기권)
	private int buyTime; // voucher가 적용가능한 시간
	private Timestamp regDate; 
	
	public Voucher() {
		
	}
	public Voucher(String vType, long buyTime) {
		
	}
	public long getVid() {
		return vid;
	}
	public void setVid(long vid) {
		this.vid = vid;
	}
	
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	public int getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(int buyTime) {
		this.buyTime = buyTime;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
}

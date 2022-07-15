package com.teamecho.chacha.voucher.domain;

public class Voucher {
	private long vid;
	private String vType;
	private int buyTime;
	
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
}

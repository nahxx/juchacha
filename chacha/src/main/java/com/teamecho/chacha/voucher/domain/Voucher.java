package com.teamecho.chacha.voucher.domain;

public class Voucher {
	private String vType;
	private String buyTime;
	
	public Voucher() {
		
	}
	
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}	
}

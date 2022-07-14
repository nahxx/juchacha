package com.teamecho.chacha.voucher.service;

import java.util.*;

import com.teamecho.chacha.voucher.domain.Voucher;
import com.teamecho.chacha.voucher.dao.VoucherDao;

public class VoucherService {
	private static final VoucherService voucherService = new VoucherService();
	private List<Voucher> voucherList = new ArrayList<Voucher>();
	private VoucherDao voucherDao;
	
	private VoucherService() {
		voucherDao = new VoucherDao();
	}
	
	public static VoucherService getInstance() {
		return voucherService;
	}
	
//	public void addVoucher(Voucher voucher) {
//		voucherList.add(voucher);
//	}
	
	public List<Voucher> getAllVouchers() {
		return voucherDao.findAllVouchers();
	}
	
	public Voucher getfindVoucherByvType(String vType) {
		return voucherDao.findVoucherByvType(vType);
	}
	
//	public void setUpdateVoucher(Voucher voucher) {
//		voucherDao.updateVoucher(voucher);
//	}
}

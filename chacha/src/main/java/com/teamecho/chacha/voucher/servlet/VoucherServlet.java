package com.teamecho.chacha.voucher.servlet;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamecho.chacha.voucher.service.VoucherService;
import com.teamecho.chacha.voucher.domain.Voucher;


@WebServlet("/voucher/voucher.do")
public class VoucherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoucherService voucherService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("진입");

		//선택한 voucher의 value값 들고오기
		String[] voucherar = request.getParameterValues("voucher");
		
		//선택유무 확인
		List<String> err = new ArrayList<String>();
	    if(voucherar == null || voucherar.length == 0) {
	    	err.add("구매하실 사항을 선택해주십시요.");
	    }
	    
		//3. 비즈니스 서비스 호출
		voucherService = VoucherService.getInstance();
		for(int i = 0; i < voucherar.length; i++) {
			String vType =  voucherar[i];
//			Voucher voucher = voucherService.getfindVoucherByvType(vType); // value값 연결  
//			System.out.println(voucher.getvType());
			System.out.println(vType);
		}
		
//		//4.다음 페이지로 이동
//		request.setAttribute("voucher", voucher);
//		dispatcher = request.getRequestDispatcher("vsuccess.jsp");
//		dispatcher.forward(request, response);
	}
}

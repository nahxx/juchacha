package com.teamecho.chacha.reservation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamecho.chacha.reservation.service.ReservationService;

@WebServlet("/reservation/rez_checking.do")
public class RezCheckingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationService service = ReservationService.getInstance();
    
	RequestDispatcher dispatcher = null; 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		
		// 1. 홈 파라메터 얻기
		
		// 2. 유효성 검증 및 변환
		
		// 3. 비즈니스 서비스 호출
		
		// 4. NextPage
	}

}

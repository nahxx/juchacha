package com.teamecho.chacha.reservation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation/rez.do")
public class RezServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // 주차장서비스 객체 생성
	RequestDispatcher dispatcher = null;
	
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 홈 파라메터 얻기
		String pId = request.getParameter("pid"); // 주차장정보창에서 예약하기 클릭시 pid코드 받아옴
		
		// 2. 유효성 검증 및 변환
		
		// 3. 비즈니스 서비스 호출
		// 주차장 서비스의 메소드 사용해서 주차장 객체 받아오기
		
		// 4. NextPage
		// request.setAttribute("", ); // 3에서 만든 주차장 객체를 던져주기
		dispatcher = request.getRequestDispatcher("reservation.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 홈 파라메터 얻기
		String type = request.getParameter("type");
		if(type == "A") {
			String start_time = request.getParameter("startTime");
			String end_time = request.getParameter("endTime");
		} else if(type == "B") { // 종일권이라면 월,일만
			String month = request.getParameter("startMonth");
			String date = request.getParameter("startDate");
		} else { // 정기권이라면 월만
			String month = request.getParameter("startMonth");
		}
	}

}

package com.teamecho.chacha.parking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamecho.chacha.parking.domain.ParkingLot;
import com.teamecho.chacha.parking.service.ParkingLotService;


@WebServlet("/parking/get_parking_point.do")
public class GetParkingLotByPoint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParkingLotService ps = ParkingLotService.getInstance();
		double pointx = 35.8665196;
		double pointy = 128.5943343;
		
		ParkingLot pl = ps.findParkingLotByPoint(pointx, pointy);
		System.out.println(pl.getParkingName());
		request.setAttribute("ParkingLot", pl);
		//지도에서 포인트 값을 던져주면 받아서 값을 가져오고 지도에 뿌려준다.
		request.getRequestDispatcher("/parkinglot/get_parking_point.jsp").forward(request, response);
	}

}

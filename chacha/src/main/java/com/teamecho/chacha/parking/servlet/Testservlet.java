package com.teamecho.chacha.parking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.teamecho.chacha.parking.domain.ParkingLot;
import com.teamecho.chacha.parking.service.ParkingLotService;


@WebServlet("/test/test.do")
public class Testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParkingLotService ps = ParkingLotService.getInstance();
		List<ParkingLot> list = ps.findAllParkingLot();
		for(ParkingLot l : list) {
			System.out.println(l.getParkingName());
		}
		double pointx = 35.8665196;
		double pointy = 128.5943343;
		
		ParkingLot pl = ps.findParkingLotByPoint(pointx, pointy);
		System.out.println(pl.getParkingName());
		
		String code = "A0001";
		ParkingLot pl2 = ps.findParkingLotByCode(code);
		System.out.println(pl2.getParkingName());
	}

}

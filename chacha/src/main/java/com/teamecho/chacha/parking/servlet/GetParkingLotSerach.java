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

@WebServlet("/parkinglot/parking_search.do")
public class GetParkingLotSerach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParkingLotService ps = ParkingLotService.getInstance();
		String search_str = (String) request.getParameter("keyword");
		System.out.println(search_str);
		List<ParkingLot> list = ps.findSearchParkingLot(search_str);
		
		request.setAttribute("ParkingLotList", list);
		request.setAttribute("ON", "ON");
		request.getRequestDispatcher("/location/location.jsp").forward(request, response);
		
//		for(ParkingLot p : list) {
//			System.out.println(p.getParkingName());
//		}
	}

}

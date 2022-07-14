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
import com.teamecho.chacha.review.domain.Review;


@WebServlet("/parking/get_parking_point.do")
public class GetParkingLotByPoint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParkingLotService ps = ParkingLotService.getInstance();
		double pointx = Double.valueOf(request.getParameter("pointX"));
		double pointy = Double.valueOf(request.getParameter("pointY"));
		ParkingLot pl = ps.findParkingLotByPoint(pointx, pointy);
		List<Review> re = ps.getAllReview(pl.getPid());
		request.setAttribute("ParkingLot", pl);
		request.setAttribute("space", ps.getParkingLotSpaces(pointx, pointy));
		request.setAttribute("favorite",true );
		
		if (re.size() !=0 || re != null) {
			request.setAttribute("review", re);
		}

		request.getRequestDispatcher("/parkinglot/get_parking_point.jsp").forward(request, response);
	}

}

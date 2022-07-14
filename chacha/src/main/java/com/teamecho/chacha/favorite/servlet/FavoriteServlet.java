package com.teamecho.chacha.favorite.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamecho.chacha.favorite.domain.Favorite;
import com.teamecho.chacha.favorite.service.FavoriteService;
import com.teamecho.chacha.parking.domain.ParkingLot;

@WebServlet("/favorite/list.do")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteService service;
	private List<Favorite> fvList;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		service = new FavoriteService();
		fvList = service.getAllFavo();

		request.setAttribute("list", fvList);
		request.getRequestDispatcher("favorite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ParkingLot parkingName = (ParkingLot) session.getAttribute("parkingName");
//		session.setAttribute("parkingName", parkingName);

//		ParkingLot pn = service.findParkingLotByPid(parkingName);

		System.out.println(parkingName);

	}

}
 
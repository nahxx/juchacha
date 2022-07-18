package com.teamecho.chacha.parking.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import com.teamecho.chacha.parking.service.ParkingLotService;
import com.teamecho.chacha.user.service.UserService;

@WebServlet("/parkinglot/favorite_parking.do")
public class GetParkingLotFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingLotService ps = ParkingLotService.getInstance();
	private UserService us = UserService.getInstance();
	private FavoriteService fs = FavoriteService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String search_str = (String) request.getParameter("keyword");
		
		String userId = (String) session.getAttribute("userId");
		long uId = us.findUIdByUserId(userId);
		
		List<Favorite> flist = ps.findFavo(uId);
		List<ParkingLot> plist = new ArrayList<>();
		
		for(Favorite f : flist) {
			long fpid = f.getPid();
			ParkingLot pl = ps.findParkingLotByPid(fpid);
			plist.add(pl);
		}
		
		request.setAttribute("falist", plist);
		
		List<ParkingLot> list = ps.findSearchParkingLot(search_str);
		request.setAttribute("search_str", search_str);
		request.setAttribute("ParkingLotList", list);
		request.setAttribute("ON", "on");
		request.getRequestDispatcher("/location/location.jsp").forward(request, response);
	}

}

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
import com.teamecho.chacha.parking.domain.ParkingLot;
import com.teamecho.chacha.parking.service.ParkingLotService;

@WebServlet("/parkinglot/favorite_parking.do")
public class GetParkingLotFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParkingLotService ps = ParkingLotService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String cheking_str = "checked";
		String search_str = "";
		String userId = (String) session.getAttribute("userId");
		
		List<Favorite> flist = ps.findFavo(ps.getUid(userId));
		List<ParkingLot> plist = new ArrayList<ParkingLot>();
		
		for(Favorite f : flist) {
			ParkingLot pl = ps.findParkingLotByPid(f.getPid());
			plist.add(pl);
		}
		request.setAttribute("cheking_str", cheking_str);
		request.setAttribute("search_str", search_str);
		request.setAttribute("ParkingLotList", plist);
		request.getRequestDispatcher("/location/location.jsp").forward(request, response);
	}

}

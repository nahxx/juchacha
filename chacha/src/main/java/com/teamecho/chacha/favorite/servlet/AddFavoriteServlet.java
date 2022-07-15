package com.teamecho.chacha.favorite.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamecho.chacha.favorite.dao.FavoriteDao;
import com.teamecho.chacha.favorite.service.FavoriteService;
import com.teamecho.chacha.parking.domain.ParkingLot;


@WebServlet("/favorite/favorite.do")
public class AddFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FavoriteService service = FavoriteService.getInstance();

	RequestDispatcher dispatcher = null;
	ParkingLot parking;
	long uId;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		FavoriteDao dao = new FavoriteDao();
		service = new FavoriteService(dao);
		
		String p = request.getParameter("pid");
		String userId = (String) session.getAttribute("userId");

		long pId = Long.valueOf(p);
		parking = service.getParkingLotByPid(Long.valueOf(p));
		uId = service.findUIdByUserId(userId);
			
		if(!service.isValidFavorite(pId, uId)) {
			service.addFavo(pId, uId);
		} else {
			service.deleFavo(pId, uId);
		}
		
		String url ="/chacha/parking/get_parking_point.do?pointX="+parking.getPointX()+"&pointY="+parking.getPointY();
		response.sendRedirect(url);
	}

}
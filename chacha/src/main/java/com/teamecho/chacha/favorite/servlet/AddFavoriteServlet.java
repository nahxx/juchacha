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
import com.teamecho.chacha.favorite.domain.Favorite;
import com.teamecho.chacha.favorite.service.FavoriteService;
import com.teamecho.chacha.parking.domain.ParkingLot;


@WebServlet("/favorite/favorite.do")
public class AddFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FavoriteService service = FavoriteService.getInstance();
    private FavoriteDao dao = new FavoriteDao();
    private Favorite fv = new Favorite();

	RequestDispatcher dispatcher = null;
	ParkingLot parking;
	long uId;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		FavoriteDao dao = new FavoriteDao();
		Favorite fv = new Favorite();
		service = new FavoriteService(dao);
		
		String p = request.getParameter("pid");
//		String u = request.getParameter("uid");
		String userId = (String) session.getAttribute("userId");

		long pId = Long.valueOf(p);
//		long uiD = Long.valueOf(u);
		parking = service.getParkingLotByPid(Long.valueOf(p));
		System.out.println(pId);
		uId = service.findUIdByUserId(userId);
			
		if(!service.isValidFavorite(pId, uId)) {
			service.addFavo(fv);
		} else {
			service.deleFavo(fv);
		}
		

//		fv.setUid(uId);
//		fv.setPid(Long.valueOf(p));
//
//		
//		service = new FavoriteService(dao);
//		service.addFavo(fv);
		request.setAttribute("fv", fv);
		
		String url ="/chacha/parking/get_parking_point.do?pointX="+parking.getPointX()+"&pointY="+parking.getPointY();
		response.sendRedirect(url);
	}

}
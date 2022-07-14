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
    
	RequestDispatcher dispatcher = null;
	ParkingLot parking;
	long uId;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		// 1. 홈 파라메터 얻기
		String p = request.getParameter("pid");
		String userId = (String) session.getAttribute("userId"); // 로그인에서 던져준 session의 유저아이디값 받아옴
		
		// 2. 유효성 검증 및 변환
		
		// 3. 비즈니스 서비스 호출
		parking = service.getParkingLotByPid(Long.valueOf(p));
		uId = service.findUIdByUserId(userId);

		// 4. NextPage
		request.setAttribute("parking", parking); // 3에서 만든 주차장 객체를 던져주기
		dispatcher = request.getRequestDispatcher("favorite.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("userId");
		String p = request.getParameter("pid");
		System.out.println(p);
		uId = service.findUIdByUserId(userId);
		
		FavoriteDao dao = new FavoriteDao();
		Favorite fv = new Favorite();
		fv.setUid(uId);
		fv.setPid(Long.valueOf(p));

		
		service = new FavoriteService(dao);
		service.addFavo(fv);
		request.setAttribute("fv", fv);
		
		dispatcher = request.getRequestDispatcher("favorite.jsp");
		dispatcher.forward(request, response);
	}
}
package com.teamecho.chacha.favorite.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamecho.chacha.favorite.dao.FavoriteDao;
import com.teamecho.chacha.favorite.domain.Favorite;
import com.teamecho.chacha.favorite.service.FavoriteService;
import com.teamecho.chacha.review.dao.ReviewDao;
import com.teamecho.chacha.review.domain.Review;
import com.teamecho.chacha.review.service.ReviewService;

@WebServlet("/favorite/favorite.do")
public class AddFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteService service;
	
	public void init(Servlet config) throws ServletException {

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String p = request.getParameter("pid");
		String u = request.getParameter("uid");
		
		FavoriteDao dao = new FavoriteDao();
		Favorite fv = new Favorite();
		fv.setPid(Long.valueOf(p));
		fv.setUid(Long.valueOf(u));

		service = new FavoriteService(dao);
		service.addFavo(fv);
		request.setAttribute("fv", fv);
		System.out.println(fv);
		
		if(!service.isValidPid(Long.valueOf(p))) {
			request.getRequestDispatcher("favorite.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("uid", u);
		session.setAttribute("pid", p);
		response.sendRedirect("list.jsp");
		
	}
}
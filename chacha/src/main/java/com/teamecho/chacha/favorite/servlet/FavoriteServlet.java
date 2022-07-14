package com.teamecho.chacha.favorite.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamecho.chacha.favorite.dao.FavoriteDao;
import com.teamecho.chacha.favorite.domain.Favorite;
import com.teamecho.chacha.favorite.service.FavoriteService;

@WebServlet("/favorite/list.do")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FavoriteService service;
	private List<Favorite> fvList;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		service = new FavoriteService();
		fvList = service.getAllFavo();
		
//		for(Favorite user : fvList) {
//		System.out.println(user.getPid());
//		System.out.println(user.getUid());
//	}

		request.setAttribute("list", fvList);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String p = request.getParameter("pid");
		String u = request.getParameter("uid");

		HttpSession session = request.getSession();
		session.setAttribute("pid", p);
		session.setAttribute("uid", u);
		String pid = (String)session.getAttribute("pid");
		String uid = (String)session.getAttribute("uid");
		System.out.println(uid + pid);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
 
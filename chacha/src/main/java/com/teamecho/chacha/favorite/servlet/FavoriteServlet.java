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


@WebServlet("/favorite/favorite.do")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FavoriteService service;
//	private List<Favorite> list = service.getAllFavo();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p = request.getParameter("pid");
		String u = request.getParameter("uid");
		Long pid = Long.valueOf(p);
		Long uid = Long.valueOf(u);

		FavoriteDao dao = new FavoriteDao();

		Favorite fv = new Favorite();
		fv.setPid(pid);
		fv.setUid(uid);
		
		service = new FavoriteService(dao);
		service.addFavo(fv);
		request.setAttribute("fv", fv);

		// 4. NextPage
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String p = request.getParameter("pid");
		String u = request.getParameter("uid");
		Long pid = Long.valueOf(p);
		Long uid = Long.valueOf(u);

	}

}

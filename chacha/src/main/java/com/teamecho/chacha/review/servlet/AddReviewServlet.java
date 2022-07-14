package com.teamecho.chacha.review.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamecho.chacha.review.dao.ReviewDao;
import com.teamecho.chacha.review.domain.Review;
import com.teamecho.chacha.review.service.ReviewService;

@WebServlet("/review/write_review.do")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String star__rating = request.getParameter("star_rating");
		String content = request.getParameter("content");
		
		Integer star_rating = Integer.valueOf(star__rating);
		
		RequestDispatcher dispatcher = null;
		ReviewDao reviewDao = new ReviewDao();
		
		Review review = new Review();
		review.setContent(content);
		review.setStar_rating(star_rating);
		
		reviewService = new ReviewService(reviewDao);
		reviewService.addReview(review);
		
		request.setAttribute("review", review);
		dispatcher = request.getRequestDispatcher("success.jsp");
		dispatcher.forward(request, response);
	}

}

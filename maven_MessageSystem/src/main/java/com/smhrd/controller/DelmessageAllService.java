package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;


public class DelmessageAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		int cnt = new MessageDAO().deleteMessageAll(email);
		
		if(cnt>0) {
			
			System.out.println("전체 메세지 삭제 성공");
			
		}else {
			System.out.println("전체 메세지 삭제 실패");
		}
		
		response.sendRedirect("Main.jsp");
		
	}

}

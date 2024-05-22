package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontcontroller.command;



public class LogoutService  implements command {
		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			//session지우기
			HttpSession session = request.getSession();
			session.removeAttribute("getEmail"); // session.invalidate(); 모든세션삭제기능(비활성화)
			System.out.println("test");
			
			
			//response.sendRedirect("Main.jsp");
			
			
			
			
			
			return "Main.jsp";
		}
		
		
		
		
		
		
		
		
		
		// 추상클래스를 이용하려고 하는데 궂이 ? 부모와자식관계를 하지않는 이유는
		// 자식관계로가면 의미가 없다  따로만들어따 자바파일로 컨트롤러로 따로 뺴놓았다
		// resq,resp 는 ......
		
		
		
		
		
		
	}


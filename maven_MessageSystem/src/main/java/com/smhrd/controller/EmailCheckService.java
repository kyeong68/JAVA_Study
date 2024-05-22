package com.smhrd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;


@WebServlet("/EmailCheckService")
public class EmailCheckService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("EmailCheckService 도착");
		String inputE = request.getParameter("inputE");
		
		boolean checkE = new MemberDAO().emailCheck(inputE);
		
		PrintWriter out;
		
		try {
		out = response.getWriter();
		out.print(checkE);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

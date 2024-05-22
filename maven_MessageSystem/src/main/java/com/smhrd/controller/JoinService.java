package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// 회원가입을 위한 서비스!
	// 1. 요청값 인코딩하여 받아오기!
	request.setCharacterEncoding("UTF-8");
		
		
		
	//2. 요청값에서 필요한 데이터 꺼내오기 
	//-> email, pw, tel,address 변수에 꺼내온 데이터 저장!
	 String email = request.getParameter("email");
     String pw = request.getParameter("pw");
    
     String tel = request.getParameter("tel");
     String address = request.getParameter("address");
		
	//3. 처리해야하는 로직 구현 -> 회원가입!
   MemberDTO dto = new MemberDTO(email, pw, tel, address);
      
    MemberDAO dao = new MemberDAO();
    int result = dao.join(dto);
        	
	//4. 결과 처리
	if(result>0) {
		//회원가입 성공시 !
		// 회원의 이메일 값을 JoinSuccess.jsp 페이지로 공유하기!
		// -> request 영역 활용하기!
		// -> 페이지 이동 방식 ->forward 방식
		//	response.sendRedirect("JoinSuccess.jsp");
		request.setAttribute("email",email);
		
		RequestDispatcher rd = request.getRequestDispatcher("JoinSuccess.jsp");
		rd.forward(request, response);
			
	}else {
		response.sendRedirect("Main.jsp");
	}
	
		
		
		
		
		
		
		
		
		
		
		
	}

}

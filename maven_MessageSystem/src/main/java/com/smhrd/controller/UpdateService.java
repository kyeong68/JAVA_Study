package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;


@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// 요청데이터 가져오기
		request.setCharacterEncoding("UTF-8");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		HttpSession session= request.getSession();
		MemberDTO loginMem = (MemberDTO)session.getAttribute("loginMem");
		
		
	// MemberDTO 객체 생성하기
		MemberDTO updateMember = new MemberDTO(loginMem.getEmail(),pw,tel,address);
		System.out.println(address);
	//DAO에 있는 update 기능 호출해보기	
		int cnt	= new MemberDAO().updateMember(updateMember);
		
	// 콘솔창에서 성공 실패 확인하기
		if(cnt>0) {
			System.out.println("수정 성공");
			session.setAttribute("loginMem", updateMember);
			response.sendRedirect("Main.jsp");
		}else {
			System.out.println("수정 실패");
			response.sendRedirect("UpdateMember.jsp");
			
		}
		
		
		
		
		
	}

}

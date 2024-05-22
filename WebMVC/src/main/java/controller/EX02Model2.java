package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model_ver1.DAO_ver1;
import model_ver1.People_DTO;


@WebServlet("/EX02Model2")
public class EX02Model2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	DAO_ver1 dao = new DAO_ver1();
	ArrayList<People_DTO> list = dao.connect();
    // 현재 인원의 수를 알아보는 기능 넣기.
    int num = list.size();
    
    // 1. forwarding 방식 . request 객체에 값 저장.
//    request.setAttribute("list",list);
//    request.setAttribute("num", num);
//    // RequestDispatcher :클라이언트로부터 최최에 들어온 요청을 원하는 자원으로 넘기는 메서드를 가짐.
//    RequestDispatcher rd = request.getRequestDispatcher("Ex02Model2.jsp");
//    //forward:  다음 페이지로 request와 response를 넘기는 역할.
////    rd.forward(request, response);
    
    
    
    // 진희 내가 만든 테스트 페이지로(sendRedirect)로 전송 넘어가기. 구글같은아이(네이버클라우드이다)
//    HttpSession session = request.getSession();
//    session.setAttribute("list", list); 
//    session.setAttribute("num", num); 
//    session.setAttribute("list",list); //문자열 넣기
//     session.setAttribute("num", num); // 숫자 넣기
//    response.sendRedirect("Ex03testModel_j.jsp");
   
		
    
    HttpSession session = request.getSession();
    session.setAttribute("list", list); 
    session.setAttribute("num", num);
    
    
    response.sendRedirect("Ex02Model2.jsp");
		
		
	}

}

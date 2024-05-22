package frontcontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.LoginService;


public class FrontContlroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("frontcontroller 들어왔당");
		
		// 어떤 요청이 들어왔는지 확인하기
		String requestURI= request.getRequestURI();
		StringBuffer requstURL  = request.getRequestURL();
		System.out.println(requestURI);
		System.out.println(requstURL);
		
		
		// context root(path) 가져오기 ->url에서 뺄려고
		String context =request.getContextPath();
		System.out.println("context :"+context);
	
		
		// 문자열 제거(자르기)
		// subString(start) : start지점부터 끝까지 문자열 자르기
		// subString(start ,end) : start부터 end 전 까지 문자열 자르기
		
		String result= requestURI.substring(context.length());
		System.out.println("요청 :"+result);
		
		
		command service = null;// 인플리먼트 구현(if문)
		String moveURL = null;
		
		
		if(result.equals("/LoginService.do")){// 클라이언트에 입력아 어디로 가려는지 확인하기 위해
			service = new LoginService();
		}else if(result.equals("/LoginService.do")) {
			service	= new LoginService();
		}
			 
			moveURL= service.execute(request, response);
			
				
			
			if(moveURL!=null) {
				response.sendRedirect(moveURL);
				
			}
		}
	
	}



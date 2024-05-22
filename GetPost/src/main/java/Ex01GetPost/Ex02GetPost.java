package Ex01GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetPost")
public class Ex02GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 1. 한글 인코딩 잡아주기
	response.setContentType("text/html;charset= UTF-8");
	
	// ** post방식으로 받아온 데이터를 한글 인코딩 하는 방법 (하나더 추가해주어야한다)
	request.setCharacterEncoding("UTF-8");
	
	
	
		//2. 요청데이터 꺼내오기
	 String name=request.getParameter("name");
	
		
		// 3. 출력도구 꺼내오기
	 PrintWriter out= response.getWriter();
		
			
		//4. 화면에 요청 데이터
	 out.print("<h3>"+name+"</h3>");
		
	}

}

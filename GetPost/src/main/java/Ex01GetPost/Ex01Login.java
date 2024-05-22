package Ex01GetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet("/Login")
public class Ex01Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		 1.한글인코딩 잡아주기
			response.setContentType("text/html;charset=UTF-8");
			// 2. 요청받은 3개 데이터 꺼내오기
			String id= request.getParameter("id");
			String pw= request.getParameter("pw");
		
		PrintWriter out = response.getWriter();
		if(id.equals("smart")&&pw.equals("123")) {
			out.print("<h3>smart</h3>");
		}else {
			out.print("<h3>로그인정보를  다시 확인하세요</h3>");
			
		}
		
		
	}

}

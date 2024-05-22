

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.RequestDumperFilter;


@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		if(id.equals("test")&&pw.equals("12345")) {
			//1 세션 id 값 넣어주기
			//1-1.  세션 객체 만들기
		HttpSession session = request.getSession();
			//1-2 . 세션에다가 id 넣기
			session.setAttribute("id", id);
			//2. 메인페이지로 이동하기
			// sendRedirect  /   forward
			// DB의 변화가 있을때  /DB의 변화가 없을때   => 사용해야 안전하다
			// 기본이 Get방식
			// -> method를 post
			//2-1. sendRedirect
//			response.sendRedirect("Ex08Main.jsp");
//			2-2. forward
		RequestDispatcher rd 	= request.getRequestDispatcher("Ex08Main.jsp");
			rd.forward(request,response);
		}else {
			// 로그인페이지로 이동 
			response.sendRedirect("Ex08LoginFrom.html");
		}
		
		
	}

}

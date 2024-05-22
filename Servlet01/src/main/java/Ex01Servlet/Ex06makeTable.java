
package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Table")
public class Ex06makeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	// 1. 한글 인코딩
		// 1.한글인코딩 잡아주기
		response.setContentType("text/html;charset=UTF-8");
		// 2. 요청받은 데이터 꺼내오기(내가꺼내올 name값을 불러온다)
		String name= request.getParameter("name");
		// ** 문자열을 숫자로 형변환**
		// 문자열을 (객체형체) 을 기본자료형(정수, 실수) 으로 변환할때는
		// Wrapper Class 를 사용해서 변환할수 있다
		// Wrapper Class 란?
		// :기본 자료형들을 마치 레퍼런스 자료형(객체형태)로 만들어 놓은것 
        // int a = Integer.parseInt(name);
		
		
		
		
		// 3. 화면에 출력도구 꺼내기
		PrintWriter out= response.getWriter();
		// 4. 요청 데이터만큼 테이블 열을 출력하기
		out.print("<table border='1\' >");
		out.print("<tr>");
		
		int a = Integer.parseInt(name);
		for(int i=1; i<=a; i++ ) {
				
		out.print("<td>");
		out.print(i);
		out.print("</td>");
			
			
			}
		out.print("</tr>");
		
		out.print("</table>");

		
	}

}

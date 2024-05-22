package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeTable")
public class EX02MakeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//1. 화면에 출력할 수 있는 도구 꺼내기
		PrintWriter out= response.getWriter();
		
		//2. 1행 6열 짜리 도구 꺼내기 
		out.print("<table border='1\' >");
		out.print("<tr>");
		
			for(int i=1; i<7; i++ ) {
				
				out.print("<td>");
				out.print(i);
				out.print("</td>");
			
			
			}
		out.print("</tr>");
		
		out.print("</table>");

}
}

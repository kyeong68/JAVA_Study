package Ex01Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/operation")
public class Ex05peration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		//      1.한글인코딩 잡아주기
				response.setContentType("text/html;charset=UTF-8");
				// 2. 요청받은 3개 데이터 꺼내오기
				String temp1= request.getParameter("num1");
				String temp2= request.getParameter("num2");
				
				String op= request.getParameter("op");
				
				// 3. ** 문자열을 숫자로 형변환**
				int num1 = Integer.parseInt(temp1);
				int num2 = Integer.parseInt(temp2);
//					4.			
				int result =0;
				if(op.equals("+")) {
					result= num1+num2;
				}else if(op.equals("-")) {
					result= num1-num2;
				}else if(op.equals("*")) {
					result= num1*num2;
				}else {
					result= num1/num2;
				}
		
	 PrintWriter out =  response.getWriter();
	 out.print("<h3>");
	 out.print(num1+op+num2+"="+result);
	 out.print("</h3>");
		
		
		
	}

}

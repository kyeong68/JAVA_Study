package Ex01Servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1) >> annotation : url mapping 값을 잡아주는 구간
//@ WebServlet("/경로")
// --> url 경로가 실행되면 (요청이 들어오면) 해당하는 파일을 실행해서 결과를 돌려준다
// 경로를 간소화 시켜서 표현하는것이 가능하다
// 파일명을 그대로 들어내지 않기 때문에 보안에 유리하다.
@WebServlet("/Create")//@ 어너테이션(url매핑)
public class Ex00CreateServlet extends HttpServlet {
	//2) 시리얼 번호 : 
	// .java -> .class -> .html 형식으로 sever 배포가 된다.
	// 해당파일이 servlet서블릿 파일임을 알려주는 코드 
	private static final long serialVersionUID = 1L;
       
  //3) 생성자 
    public Ex00CreateServlet() {// 기본 생성자메소드 
        super();
       System.out.println("생성자 호출");
    }

    // 4. 서블릿 초기화 시켜주는 메소드(initialize)
	public void init(ServletConfig config) throws ServletException { //접근제한자, 초기화(init)
		System.out.println("초기화 메소드 실행");
		
		
	}

	//5. servlet 을 소멸시키고 싶을때 사용하는 메소드
	public void destroy() {//파괴하다 소멸
		System.out.println("destroy 메소드 호출");
	}

	// ★ 6. java에서 main 메소드 역할, 요청이 들어오면 실행되는 메소드(응답, 객체)★
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service  메소드 실행");
	}

	// 7. doGet, doPost --> sever로 요철이 들어오는 방식이 다양하다
	// Get 방식으로 요청이 들어올 때 실행하고 싶을 메소드 :doGet
	// post 방식으로 요청이 들어올 때 실행하고 싶을 메소드 :doPost
	// dy
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.smhrd.controiier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;

public class LoginService2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		Member member = new Member(id, pw);

		MemberDAO dao = new MemberDAO();
		Member loginMember = dao.login(member);

		if (loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", loginMember);
			response.sendRedirect("main.jsp");

		} else {
			response.sendRedirect("login.jsp");
		}

	}

}

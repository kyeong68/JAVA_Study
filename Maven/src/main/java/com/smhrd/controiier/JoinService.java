package com.smhrd.controiier;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.Member;
import com.smhrd.model.MemberDAO;

public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");

		Member member = new Member(id, pw, nick);
		MemberDAO dao = new MemberDAO();
		int row = dao.join(member);

		if (row > 0) {
			response.sendRedirect("login.html");
		} else {
			response.sendRedirect("join.html");
		}

	}

}

package com.smhrd.controiier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.smhrd.model.Member2;

public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("왔따!!!");

		// 사용자가 입력한 Id 값 꺼내기
		String id = request.getParameter("inputId");

		// id에 있는 값이 'smart' 라면 1 반환
		// 아니라면 0 반환
		// 반환 --> PrintWriter 객체를 통해서 가능하다!!
		
			
		PrintWriter out = response.getWriter();
				
		// 회원 정보 전달
		// 이름 ,나이, 전화번호, 이메일
		
		  ArrayList<Member2> myList= new ArrayList<Member2>();
	      myList.add(new Member2("승환", 20,"01012345678", "naver"));
	      myList.add(new Member2("승환1", 20,"01012345678", "naver"));
	      myList.add(new Member2("승환2", 20,"01012345678", "naver"));
	      myList.add(new Member2("승환3", 20,"01012345678", "naver"));
	      myList.add(new Member2("승환4", 20,"01012345678", "naver"));
	      myList.add(new Member2("승환5", 20,"01012345678", "naver"));
		//여러개의 데이터를 한번에 넘길때 
		//JavaScript 에서 바로 사용할수 있도록 -> Json 객체로 넘겨야한다
		// Gson--> java 의 객체를 json 객체로 변환 시키는 기능
	      
	      
	      Gson gson = new Gson();
		if(id.equals("smart")) {
		//gson.toJson(myList) : myList 를 Json 형식 변환
			out.print(gson.toJson(myList));
		
	}else {
		 out.print(0);
	}

}
}

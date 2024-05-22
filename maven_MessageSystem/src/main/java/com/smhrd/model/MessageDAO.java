package com.smhrd.model;

import java.util.ArrayList;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MessageDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlsession();

	// 메세지 전송 메소드 생성
	public int sendMessage(MessageDTO dto) {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		int result = sqlSession.insert("sendMessage", dto);

		sqlSession.close();

		return result;
	}

	// 메세지 확인을 위한 메소드 생성
	   public ArrayList<MessageDTO> showMessage(String email){
		   
		  // 사용할 ArrayList 생성!
		   ArrayList<MessageDTO> m_list = new ArrayList<>();
		   
		   
		   // 1. sql 대여
		 SqlSession sqlSession = sqlSessionFactory.openSession(true);
		   
		   
		   // 2. sql 실행-> ArrayList 타입
		  
		   
		   
		   // 3. sql 처리
		  
		  m_list=(ArrayList)sqlSession.selectList("showMessage",email);
		   
		   // 4. sql 반납
		  sqlSession.close();
		   System.out.println(m_list.size());
		 	   
		   
		   return m_list;
		   
	   }
	   
	   public int deleteMassage(int num) {
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			int cnt =sqlSession.delete("deleteMessage",num);
			sqlSession.close();
			return cnt;
		}
	
	   public int deleteMessageAll(String email) {
		   SqlSession sqlSession = sqlSessionFactory.openSession(true);
		  int cnt = sqlSession.delete("deleteMessageAll",email);
		   sqlSession.close();
		   return cnt;
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
	   }
	   
	
}

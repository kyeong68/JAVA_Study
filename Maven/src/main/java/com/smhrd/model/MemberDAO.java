package com.smhrd.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDAO {

	// SqlSessionFactory 불러오기 :DB 관련 기능을 사용할수 있는 세션을 만들어주는 공장.
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSession();

	// 각 기능을 수행하는 세션을 저장하는 변수.
	SqlSession sqlSession;

	// 기존 DAO 처럼 각 SQL문을 실행할 메서드 만들기
	public Member login(Member member) {
		// openSession(autocommit)
		sqlSession = sqlSessionFactory.openSession(true);
		Member longinMember = null;

		try { // 쿼리를 실행했을 때 결과가 없을 수도 있으므로
			longinMember = sqlSession.selectOne("MemberSQL.Loginselect", member);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			sqlSession.close();
		}
		
		return longinMember;
	}
	
	
	// 회원가입 기능.
	public int join(Member member) {
		
		sqlSession = sqlSessionFactory.openSession(true);
		int res = sqlSession.insert("MemberSQL.JoinInsert", member);
		
		sqlSession.close();
		
		return res;
		
	}

}

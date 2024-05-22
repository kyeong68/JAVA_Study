package com.smhrd.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class MemberDAO {

	// 데이터베이스에 연결하여 쓸 수 있는 기능 작업!

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlsession();
	SqlSession sqlSession = sqlSessionFactory.openSession(true);

	// 회원가입 메소드 생성
	public int join(MemberDTO dto) {
		// 1. sqlSession 빌려오기!
		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		// 2. sql문장 전달 !
		int result = sqlSession.insert("join", dto);

		// 3. 결과 처리
		if (result > 0) {
			System.out.println("회원가입 성공!");
		}

		// 4. sqlSession 반납!
		sqlSession.close();

		return result;

	}

	public MemberDTO login(MemberDTO dto) {
		// openSession(autocommit)
		sqlSession = sqlSessionFactory.openSession(true);
		MemberDTO loginMember = null;

		try { // 쿼리를 실행했을 때 결과가 없을 수도 있으므로
			loginMember = sqlSession.selectOne("login", dto);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			sqlSession.close();
		}
		return loginMember;
	}

	// 회원정보를 수정하는 메서드
	public int updateMember(MemberDTO updateMember) {
		int cnt = 0;

		cnt = sqlSession.update("updateMember", updateMember);// DTO를 들고가야한다
		sqlSession.close();

		return cnt;
	}

	// 전체회원 조회
	public List<MemberDTO> allMember() {

		List<MemberDTO> members = null;

		try {
			members = sqlSession.selectList("allMember");
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return members;
	}
	
	// 회원삭제 
	public int deleteMember(String email) {
		int cnt = 0;
		try {
		cnt = sqlSession.delete("deleteMember",email);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return cnt;
		}
		
		// DAO의 중복확인
//	public boolean emailCheck(String inputE) {
//		boolean checkE = false;
//		
//		try {
//		sqlSession.selectOne("emailcheck",inputE);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			sqlSession.close();
//		}
//		
//		return checkE;
//		
//		
//	}
	
	
	//중복확인
	   
	   public boolean emailCheck (String inputE) { 
	      
	      boolean checkE = false;
	      try {checkE   = sqlSession.selectOne("emailCheck", inputE);}
	   catch(Exception e){
	      e.printStackTrace();
	   }
	      finally {sqlSession.close();}
	      
	      return checkE;
	      
	   }
	
	
	
	
 
}

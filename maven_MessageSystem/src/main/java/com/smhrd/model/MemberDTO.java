package com.smhrd.model;

public class MemberDTO {
	// web_member 테이블에 대한 내용을 설계하는 DTO

	private String email;
	private String pw;
	private String tel;
	private String address;

	// 생성자 메소드
	public MemberDTO(String email, String pw, String tel, String address) {

		this.email = email;
		this.pw = pw;
		this.tel = tel;
		this.address = address;

	}

	// 기본생성자 메소드 -> 이런방법으로 넣어서 하는법도 알려주심!
	public MemberDTO() {

	}

	// public MemberDTO(String email, String pw) {

	// this.email = email;
	// this.pw = pw;
	// }

	// getter/setter 메소드 생성!
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

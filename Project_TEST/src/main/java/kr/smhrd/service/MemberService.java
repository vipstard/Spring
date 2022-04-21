package kr.smhrd.service;

import kr.smhrd.domain.MemberVO;

public interface MemberService {
	//회원가입
	public void Join(MemberVO vo);
	
	//로그인
	public MemberVO Login(MemberVO vo);
	
	// 아이디 중복체크
	public int idCheck(String id);
		
	// 이메일 중복체크
	public int emailCheck(String email);
	
	// 아이디 찾기
	public String find_id(String name, String phone);
	
	//회원 수정
	public void memberUpdate(MemberVO vo);
}

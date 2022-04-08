package kr.smhrd.service;

import kr.smhrd.domain.MemberVO;

public interface MemberService {
	//회원가입
	public void Join(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO Login(MemberVO vo);
}

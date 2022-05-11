package kr.smhrd.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.smhrd.domain.MemberVO;

public class MemberServiceImple implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	
	// 회원가입 mapper 접근
	@Override
	public void Join(MemberVO vo) {
		mapper.MemberJoin(vo);
	}
}

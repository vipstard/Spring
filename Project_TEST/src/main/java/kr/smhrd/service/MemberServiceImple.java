package kr.smhrd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.mapper.MemberMapper;

@Service
public class MemberServiceImple implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	public void Join(MemberVO vo) {
		mapper.MemberJoin(vo);
		
	}
	
	public MemberVO Login(MemberVO vo) {
	MemberVO VO = mapper.MemberLogin(vo);
	
		return VO;
		
	}

}

package kr.smhrd.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.mapper.MemberMapper;

public interface MemberService{
	
	public void Join(MemberVO vo);

}

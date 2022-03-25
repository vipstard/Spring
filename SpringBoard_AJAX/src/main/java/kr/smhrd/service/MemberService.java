package kr.smhrd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.Board;
import kr.smhrd.domain.Member;
import kr.smhrd.mapper.BoardMapper;
import kr.smhrd.mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private MemberMapper mapper;
	
	public Member login(Member vo) {
		Member VO = mapper.login(vo);
		
		return VO;
		
	}
	
	
}

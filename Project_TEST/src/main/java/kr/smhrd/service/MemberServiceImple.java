package kr.smhrd.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.mapper.MemberMapper;
import lombok.extern.java.Log;

@Service
public class MemberServiceImple implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	
	// 회원가입 mapper 접근
	@Override
	public void Join(MemberVO vo) {
		mapper.MemberJoin(vo);
	}
	
	//로그인 mapper 접근
	@Override
	public MemberVO Login(MemberVO vo) {
		System.out.println("Service : " + vo);
	MemberVO VO = mapper.MemberLogin(vo);
	
	return VO;	
	}
	
	//아이디 중복체크 mapper 접근
		@Override
		public int idCheck(String id) {
			int cnt = mapper.idCheck(id);
			System.out.println("cnt: " + cnt);
			return cnt;
		}
		

	//이메일 중복체크 mapper 접근
	@Override
	public int emailCheck(String email) {
		int cnt = mapper.emailCheck(email);
		System.out.println("cnt: " + cnt);
		return cnt;
	}
	
	// 아이디 찾기
	@Override
	public String find_id(String name, String phone) {
			
		String result = "";
		
		try {
		 result= mapper.find_id(name, phone);
		 
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return result ;
	}

	//회원정보 수정
	@Override
	public void memberUpdate(MemberVO vo) {
		System.out.println("Service : " + vo);
		mapper.MemberUpdate(vo);
	}

	//회원리스트
	@Override
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = mapper.memberList();
		return list;
	}
	
	
	

	
	
	

}

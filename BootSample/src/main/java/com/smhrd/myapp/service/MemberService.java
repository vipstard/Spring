package com.smhrd.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.myapp.domain.Member;
import com.smhrd.myapp.mapper.MemberMapper;
import com.smhrd.myapp.repo.MemberRepo;

@Service
public class MemberService {
	
	@Autowired
	MemberRepo repo;
	
	@Autowired
	MemberMapper mapper;
	
	public List<Member> datafindAllMB(){
		List<Member> list = mapper.dataFindAllMB();
		return list;
		
		
	}
	
	public List<Member> dataFindAllJPA(){
		
		return repo.findAll();
	}
	
	public Member findAdmin(String id) {
		return repo.findAdmin(id);
		
	}
	
}

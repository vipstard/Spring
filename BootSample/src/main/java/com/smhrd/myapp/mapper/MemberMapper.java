package com.smhrd.myapp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.smhrd.myapp.domain.Member;

@MapperScan
public interface MemberMapper {
	
	public List<Member> dataFindAllMB();
	
		
	
}

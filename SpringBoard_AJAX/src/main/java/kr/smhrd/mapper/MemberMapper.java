package kr.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.smhrd.domain.Member;

@Mapper
public interface MemberMapper {
	
	@Select("Select * from SPRINGMEMBER where memid=#{memId} and mempw=#{memPw}")
	public Member login(Member vo);
	
	//1. 반환타입
	//2. SQL (annotation)
	//3. mapper interface
	//4. mapper - login() 호출
	//5. 반환 값
	

}

package kr.smhrd.mapper;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;

public interface MemberMapper {
	
	//회원 가입
	@Insert("insert into user_info(user_id, user_pw, user_name, user_phone, user_email, "
			+ "user_addr, admin_yn, user_joindate)values(#{id},"
			+ " #{pw}, #{name}, #{phone}, #{email}, #{address}, )")
	public void MemberJoin(MemberVO vo);
	
	
	
}

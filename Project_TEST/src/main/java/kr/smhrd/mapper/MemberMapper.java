package kr.smhrd.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.smhrd.domain.MemberVO;

public interface MemberMapper {
	
	@Insert("insert into t_member(idx, name, nick, email, address, indate, pw) values(TMember_seq.nextval, #{name}, #{nick}, #{email}, #{address}, sysdate, #{pw})")
	public void MemberJoin(MemberVO vo);
	
	@Select("Select * from T_MEMBER where email=#{email} and pw=#{pw}")
	public MemberVO MemberLogin(MemberVO vo);
}

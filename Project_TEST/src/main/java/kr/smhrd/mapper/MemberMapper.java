package kr.smhrd.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.domain.MemberVO;

public interface MemberMapper {
	
	//회원 가입
	@Insert("insert into t_member(idx, name, nick, email, address, indate, pw, phone, id) values(TMember_seq.nextval, #{name},"
			+ " #{nick}, #{email}, #{address}, sysdate, #{pw}, #{phone}, #{id})")
	public void MemberJoin(MemberVO vo);
	
	//로그인
	//@Select("Select * from T_MEMBER where id=#{id} and pw=#{pw}")
	public MemberVO MemberLogin(MemberVO vo);
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 이메일 중복체크
	public int emailCheck(String email);
	
	//아이디 찾기
	@Select("select nvl(email, 0) from t_member where name=#{name} and phone=#{phone}")
	public String find_id(@Param("name") String name, @Param("phone") String phone);
	
	//회원정보 수정
	public void MemberUpdate(MemberVO vo);
}

package kr.smhrd.domain;

import lombok.Data;

@Data
public class MemberVO {
	private int rowNum;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_phone;
	private String user_eamil;
	private String user_addr;
	private char admin_yn;
	private String joindate;
	

}

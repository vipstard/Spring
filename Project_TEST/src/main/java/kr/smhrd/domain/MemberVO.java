package kr.smhrd.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MemberVO {
	private int idx;
	private String id;
	private String name;
	private String pw;
	private String nick;
	private String email;
	private String Address;
	private String indate;
	private String phone;
	private String ad_ck;
	
	
}

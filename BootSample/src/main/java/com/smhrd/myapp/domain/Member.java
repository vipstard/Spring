package com.smhrd.myapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="web_member")


public class Member {
	@Id
	private String id;
	private String pw;
	private String nick;
	
	

}

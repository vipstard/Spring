package kr.smhrd.domain;

import lombok.Data;

@Data
public class Book {
	private int num;
	private String title;
	private String author;
	private String company;
	private String isbn;
	private int count;
}

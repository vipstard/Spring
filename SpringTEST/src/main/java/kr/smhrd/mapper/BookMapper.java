package kr.smhrd.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


import kr.smhrd.domain.Book;

@Mapper
public interface BookMapper {
	
	public ArrayList<Book> bookList();
	
	@Delete ("delete from book where num=#{num}")
	public void bookDelete(int num);
	

}

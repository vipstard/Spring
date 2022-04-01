package kr.smhrd.myapp1;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.domain.Book;
import kr.smhrd.mapper.BookMapper;

@RestController
public class BookRestController {
	
	@Autowired
	private BookMapper mapper;
	
	@RequestMapping("/boardListAjax.do")
	public  ArrayList<Book> boardListAjax(){
		 ArrayList<Book> list = mapper.bookList();
		return list;
	}

}

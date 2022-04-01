package kr.smhrd.myapp1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.domain.Book;
import kr.smhrd.mapper.BookMapper;

@Controller
public class BookController {
	
	@Autowired
	private BookMapper mapper;
	
	@RequestMapping("/bookList.do")
	public String bookList(Model model) {
		List<Book> list = mapper.bookList();
		model.addAttribute("list", list);
		return "bookList";
	}
	
	@GetMapping("/bookDelete.do/{num}")
	public String bookDelete(@PathVariable int num) {
		mapper.bookDelete(num);
		return "redirect:/bookList.do";
	}

}

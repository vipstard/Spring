package kr.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.MemberServiceImple;

@Controller
public class MemberController {
	
	
	@Autowired
	private MemberServiceImple memberService;
	
	
	
	// 회원가입
	@PostMapping("/Join")
	public String Join(MemberVO vo) {
		System.out.println("회원가입");
		System.out.println(vo.getUser_id() + " " + vo.getUser_name() + " " + vo.getUser_eamil());
		try {
			memberService.Join(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/boardList";
	}
	
	
}

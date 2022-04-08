package kr.smhrd.myapp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.MemberService;





@Controller
public class MemberController {
	@Autowired
	private MemberService MemberService;
	
	
	
	@PostMapping("/Join.do")
	public String Join(MemberVO vo) {
		System.out.println("회원가입");
		System.out.println(vo.getName());
		try {
			MemberService.Join(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	
	}
	
	@PostMapping("/Login.do")
	public String Login(MemberVO vo, HttpSession session) {
		System.out.println("로그인 " + vo.getEmail() + " " + vo.getPw());
		MemberVO Login = MemberService.Login(vo);
		
		
		if(Login!=null) {
			session.setAttribute("LoginVo", Login);
		}
		
		System.out.println("로그인 " + Login.getEmail() +" " + Login.getPw());
		return "redirect:/";
		
	}
	
	@RequestMapping("/LogOut.do")
	public String LogOut(HttpSession session) {
		
		session.removeAttribute("LoginVo");
		
		return "redirect:/";
		
	}

}

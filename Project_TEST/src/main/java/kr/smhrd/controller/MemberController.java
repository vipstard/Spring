package kr.smhrd.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	// 회원가입
	@PostMapping("/Join")
	public String Join(MemberVO vo) {
		System.out.println("회원가입");
		System.out.println(vo.getId() + " " + vo.getName() + " " + vo.getEmail());
		try {
			memberService.Join(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/boardList";
	}
	
	// 회원 로그인
	@PostMapping("/Login")
	public String Login(MemberVO vo, HttpSession session) {
		System.out.println("로그인 " + vo.getEmail() + " " + vo.getPw());
		MemberVO Login = memberService.Login(vo);
		
		if(Login!=null) {
			session.setAttribute("LoginVo", Login);
		}
		
		System.out.println("로그인 " + Login.getEmail() +" " + Login.getPw());
		return "redirect:/boardList";
	}
	
	// 회원 로그아웃
	@RequestMapping("/LogOut")
	public String LogOut(HttpSession session) {
		
		session.removeAttribute("LoginVo");
		return "redirect:/boardList";
	}
	
	
	
	//아이디 중복체크
		@PostMapping("/idCheck")
		@ResponseBody
		public int idCheck(@RequestParam("id") String id) {
			
			//logger.info("userIdCheck 진입");
			//logger.info("전달받은 id:"+email);
			
			int cnt = memberService.idCheck(id);
			return cnt;
			
		}
		
	//이메일 중복체크
	@PostMapping("/emailCheck")
	@ResponseBody
	public int emailCheck(@RequestParam("email") String email) {
		
		//logger.info("userIdCheck 진입");
		//logger.info("전달받은 id:"+email);
		
		int cnt = memberService.emailCheck(email);
		return cnt;
		
	}
	
	//아이디 찾기 
	@RequestMapping(value = "/find_id", method = RequestMethod.POST)
	@ResponseBody
	public String find_id(@RequestParam("name") String name,@RequestParam("phone") String phone) {
		System.out.println(name + " " + phone);
		String result = memberService.find_id(name, phone);
		
		return result;
	}
	
	
	//회원 정보 수정
	@RequestMapping(value="/memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(MemberVO vo) {
		
		System.out.print("회원수정 컨트롤러 ");
		System.out.println(vo.getEmail() + " " + vo.getPw());
		
		try {
			memberService.memberUpdate(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/boardList";
	}

}

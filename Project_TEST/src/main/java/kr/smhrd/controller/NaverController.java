package kr.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NaverController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		log.info("home controller");
		return "APIExamNaverLogin";
	}

	@RequestMapping(value = "login/oauth2/code/naver", method = RequestMethod.GET)
	public String loginPOSTNaver(HttpSession session) {
		log.info("callback controller");
		return "callback";
	}

	
}

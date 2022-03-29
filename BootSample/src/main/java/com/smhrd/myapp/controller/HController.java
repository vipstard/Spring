package com.smhrd.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HController {
	
	@RequestMapping("/main")
	public String home() {
		
		return "main";
	}
	
	

}

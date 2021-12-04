package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repository.UserDetailsRepo;

@Controller
public class MyClass {
	
	private UserDetailsRepo ud;
//	private MainService implService;

	public MyClass(UserDetailsRepo ud) {
		this.ud = ud;
	}


	@RequestMapping("/")
	String indexPage(HttpSession session) {
		if(session.getAttribute("id")==null) {
			return "signin";
		}
		
		return "Home";
	}
	
	
}

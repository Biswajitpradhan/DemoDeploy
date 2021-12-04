package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.UserDetails;
import com.example.demo.Repository.UserDetailsRepo;
import com.example.demo.services.MainService;

@Controller
public class MyClass {
	
	private UserDetailsRepo ud;
	@Autowired
	private MainService implService;

	public MyClass(UserDetailsRepo ud) {
		this.ud = ud;
	}


	@RequestMapping("/")
	String indexPage(HttpSession session) {
		if(session.getAttribute("id")==null) {
			return "signin";
		}
		
		return "home";
	}
	
	@PostMapping("/signinUser")
	String RegisterPage(@ModelAttribute UserDetails userDetails) {
		ud.save(userDetails);
		return "redirect:/";
	}
	
	@GetMapping("/homepage")
	String home(HttpSession session) {
//		if(session.getAttribute("id")==null) {
//			return "redirect:/";
//		}
		return "home";
	}
	
	@RequestMapping("/test")
	String testModel() {
		return "redirect:homepage";
	}
	
	@PostMapping("/login")
	String LoginPage(@RequestParam("email") String mail,@RequestParam("password") String pass, HttpSession session)
	{
		Optional<UserDetails> b=implService.checkUser(mail, pass);
		if(b.isPresent()) {
			
			session.setAttribute("user", b.get().getUsername());
			session.setAttribute("id",session.getId());
			session.setMaxInactiveInterval(12000);
			
			System.out.println(session.getAttribute("id"));
			return "redirect:homepage";
		}
		return "redirect:/";
	}
	
	@GetMapping("/customizeProduct")
	String Customize(HttpSession session) {
		if(session.getAttribute("id")==null) {
			return "redirect:/";
		}
		return "customize";
	}
	
	
}

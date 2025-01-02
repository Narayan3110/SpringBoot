package com.cdac.training.usersoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdac.training.usersoft.model.User;
import com.cdac.training.usersoft.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



/**
*Author : ${user}
*Date :31-Dec-2024
*Time:11:58:49 am
*/

@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
	
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegisterForm(Model m) {
		
		User user = new User();
		m.addAttribute("user",user);
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user,Model m) {
		
		userService.registerUser(user);
		m.addAttribute("message" , "Registartion successfull!!!!!");
		return "index";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam String email ,@RequestParam String passwords , HttpSession session , Model model) {
		var user = userService.loginUser(email,passwords);	
		System.out.println(user);
		if(user.isPresent()) {
			session.setAttribute("loggedUser", user.get());
			return "redirect:/home";
		}else {
			model.addAttribute("error","Invalid user try again");
			return "login";
		}
		
	}
	
	@GetMapping("/home")
	public String getMethodName(HttpSession session , Model model) {
		var user = session.getAttribute("loggedUser");
		if(user == null){
			return "redirect:/login";
		}
		model.addAttribute("user" , user);
		return "home";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // end session
        return "redirect:/index";
    }
	
	
	
	
	
	
}

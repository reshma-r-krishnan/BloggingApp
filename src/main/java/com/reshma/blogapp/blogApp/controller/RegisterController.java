package com.reshma.blogapp.blogApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.reshma.blogapp.blogApp.dto.Registerdto;
import com.reshma.blogapp.blogApp.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/register")
	public String register(){
		
		return "/register";	
	}
	
	@PostMapping("/register")
	public String registerNewUser(@RequestBody Registerdto user) {
		
		if(userservice.findByEmail(user.getEmail()).isPresent()) {
			return "Already registerd user";
		}
		
		if(userservice.findByUsername(user.getName()).isPresent()) {
			return "UserName already exists";
		}
		userservice.save(user);
		return "redirect:/";
	}
}

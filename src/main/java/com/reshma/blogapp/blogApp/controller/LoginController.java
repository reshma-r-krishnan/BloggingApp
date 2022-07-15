package com.reshma.blogapp.blogApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.app.blog.models.userResponse;
import com.app.blog.util.JWTUtil;
import com.reshma.blogapp.blogApp.dto.Logindto;

@Controller
public class LoginController {

	
	@Autowired
	private JWTUtil util;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/login")
	public String login() {
		
		return "/login";
	}
	@PostMapping("/login")
	public ResponseEntity<userResponse> loginUser(@RequestBody Logindto request){
		
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUserName(), request.getPassword()));
		
		String token= util.GenerateToken(request.getUserName());
		return ResponseEntity.ok(new userResponse(token,"Successuffly generated!!"));
	}
}

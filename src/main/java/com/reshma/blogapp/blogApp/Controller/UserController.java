package com.reshma.blogapp.blogApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reshma.blogapp.blogApp.Model.User;
import com.reshma.blogapp.blogApp.Service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser( @RequestBody User user) {
		
		userService.save(user);
		return ResponseEntity.ok("User registered successfully");
	}
	
	@GetMapping("/users")
	public List<User> allUsers(){
		
		return userService.getAllUsers();
			
	}
	
	
	
}

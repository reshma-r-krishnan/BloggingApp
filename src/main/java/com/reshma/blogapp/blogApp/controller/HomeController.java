package com.reshma.blogapp.blogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reshma.blogapp.blogApp.model.Post;
import com.reshma.blogapp.blogApp.service.PostService;

@Controller
public class HomeController {
	
	@Autowired
	private PostService postservice;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<Post> posts= postservice.getAll();
		model.addAttribute("Posts",posts);
		
		return "home";
	}

}

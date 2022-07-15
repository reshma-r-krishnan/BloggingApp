package com.reshma.blogapp.blogApp.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reshma.blogapp.blogApp.model.Post;
import com.reshma.blogapp.blogApp.model.User;
import com.reshma.blogapp.blogApp.service.PostService;
import com.reshma.blogapp.blogApp.service.UserService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postservice;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/posts/{id}")
	public String getpost(@PathVariable int id,Model model) {
		
		Optional<Post> optpost= postservice.findById(id);
		
		if(optpost.isPresent()) {
			
			Post post= optpost.get();
			model.addAttribute("posts",post);
			return "post";
		}
		else {
            return "404";
        }
		
	}
	
	@GetMapping("/posts/new")
	public String newPost(Model model,Principal principal) {
		
		Optional<User> opt_user= userservice.findByUsername(principal.getName());
		
		if(opt_user.isPresent()) {
			
			Post post= new Post();
			post.setUser(opt_user.get());
			model.addAttribute("posts",post);
			
			return "post_new";
		}else {
			return "404";
		}
	}
	
	
	@PostMapping("/posts/new")
	public String createNewpost(@ModelAttribute Post post){
		
		postservice.save(post);
		
		return "redirect:/posts/" + post.getId();
		
	}
	
	@GetMapping("/posts/{id}/edit")
	public String editPostwithId(@PathVariable int id,Model model) {
		
		Optional<Post> opt_post= postservice.findById(id);
		
		if(opt_post.isPresent()) {
			
			Post post= opt_post.get();
			model.addAttribute("posts",post);
			return "post_edit";
		}
		else {
            return "404";
        }
	}

	@GetMapping("/posts/{id}/delete")
	public String deleteById(@PathVariable int id) {
		
		Optional<Post> opt_post= postservice.findById(id);
		
		if(opt_post.isPresent()) {
			
			Post post= opt_post.get();
			postservice.delete(post);
			 return "redirect:/";
		}
		else {
			return "404";
		}
	}
}

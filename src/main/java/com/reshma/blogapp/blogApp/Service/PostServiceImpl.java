package com.reshma.blogapp.blogApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reshma.blogapp.blogApp.model.Post;
import com.reshma.blogapp.blogApp.model.User;
import com.reshma.blogapp.blogApp.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Optional<Post> findById(Integer id) {
		return postRepository.findById(id);
	}

	@Override
	public Post save(Post post) {
		
		return postRepository.save(post);
	}

	
	public List<Post> getAll() {
	        return postRepository.findAll();
	    }

	@Override
	public void delete(Post post) {

		postRepository.delete(post);
	}

}

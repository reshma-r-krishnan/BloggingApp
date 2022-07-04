package com.reshma.blogapp.blogApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.reshma.blogapp.blogApp.Model.Post;
import com.reshma.blogapp.blogApp.Model.User;
import com.reshma.blogapp.blogApp.Repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Optional<Post> findForId(Integer id) {
		return postRepository.findById(id);
	}

	@Override
	public Post save(Post post) {
		
		return postRepository.save(post);
	}

	@Override
	public Page<Post> findByUserOrderedByDatePageable(User user, Pageable pageable) {
		return postRepository.findByUserOrderByCreateDateDesc(user, pageable);
	}

	@Override
	public Page<Post> findAllOrderedByDatePageable(Pageable pageable) {
		return postRepository.findAllByOrderByCreateDateDesc(pageable);
	}

	@Override
	public void delete(Post post) {

		postRepository.delete(post);
	}

}

package com.reshma.blogapp.blogApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reshma.blogapp.blogApp.model.Post;
import com.reshma.blogapp.blogApp.model.User;

public interface PostService {
	
    Optional<Post> findById(Integer id);

    Post save(Post post);

    List<Post> getAll() ;
    
    void delete(Post post);

}

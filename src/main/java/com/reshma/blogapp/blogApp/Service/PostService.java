package com.reshma.blogapp.blogApp.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.reshma.blogapp.blogApp.Model.Post;
import com.reshma.blogapp.blogApp.Model.User;

public interface PostService {
	
    Optional<Post> findForId(Integer id);

    Post save(Post post);

    Page<Post> findByUserOrderedByDatePageable(User user, Pageable pageable);

    Page<Post> findAllOrderedByDatePageable(Pageable pageable);

    void delete(Post post);

}

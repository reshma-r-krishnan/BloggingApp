package com.reshma.blogapp.blogApp.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reshma.blogapp.blogApp.Model.Post;
import com.reshma.blogapp.blogApp.Model.User;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

    Page<Post> findByUserOrderByCreateDateDesc(User user, Pageable pageable);

    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

    Optional<Post> findById(Integer id);
}

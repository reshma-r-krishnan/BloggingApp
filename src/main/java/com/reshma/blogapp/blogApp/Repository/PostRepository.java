package com.reshma.blogapp.blogApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reshma.blogapp.blogApp.model.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

 

    Optional<Post> findById(Integer id);
}

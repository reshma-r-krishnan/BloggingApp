package com.reshma.blogapp.blogApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reshma.blogapp.blogApp.dto.Registerdto;
import com.reshma.blogapp.blogApp.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String name);
	Optional<User> findByemail(String email);
	Registerdto save(Registerdto user);
}

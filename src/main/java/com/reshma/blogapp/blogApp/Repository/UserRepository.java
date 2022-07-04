package com.reshma.blogapp.blogApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reshma.blogapp.blogApp.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String name);
	Optional<User> findByemail(String email);
}

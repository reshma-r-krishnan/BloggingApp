package com.reshma.blogapp.blogApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reshma.blogapp.blogApp.dto.Registerdto;
import com.reshma.blogapp.blogApp.model.User;
import com.reshma.blogapp.blogApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<User> findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByemail(email);
	}

	@Override
	public Registerdto save(Registerdto user) {
		user.setPassword(
				passwordEncoder.encode(user.getPassword())
				);
		return userRepository.save(user);
	}
	

}

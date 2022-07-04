package com.reshma.blogapp.blogApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reshma.blogapp.blogApp.Model.User;
import com.reshma.blogapp.blogApp.Repository.UserRepository;

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
	public User save(User user) {
		user.setPassword(
				passwordEncoder.encode(user.getPassword())
				);
		return userRepository.save(user);
	}
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public void DeleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}

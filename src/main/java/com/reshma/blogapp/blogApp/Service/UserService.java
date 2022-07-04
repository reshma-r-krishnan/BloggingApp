package com.reshma.blogapp.blogApp.Service;

import java.util.List;
import java.util.Optional;

import com.reshma.blogapp.blogApp.Model.User;

public interface UserService {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
    List<User> getAllUsers();

}

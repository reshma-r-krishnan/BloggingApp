package com.reshma.blogapp.blogApp.service;


import java.util.Optional;

import com.reshma.blogapp.blogApp.dto.Registerdto;
import com.reshma.blogapp.blogApp.model.User;

public interface UserService {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Registerdto save(Registerdto user);
   

}

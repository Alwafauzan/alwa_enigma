package com.example.cobajwt.service;

import com.example.cobajwt.model.User;

public interface UserService {
    User save(User user);

    User findByUsername(String username);
}

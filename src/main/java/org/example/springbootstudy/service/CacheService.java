package org.example.springbootstudy.service;

import org.example.springbootstudy.entity.User;

public interface CacheService {
    User getUser(Integer id);

    // void insertUser(User user);

    // void removeUser(Integer id);

    // List<User> getAllUser();
}

package org.example.springbootstudy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springbootstudy.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    User saveUser(User user);
    int removeUser(Integer id);
    User updateUser(User user);
    User findById(Integer id);
    List<User> findAll();
}

package org.example.springbootstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.example.springbootstudy.entity.User;
import org.example.springbootstudy.mapper.UserMapper;
import org.example.springbootstudy.service.UserService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "org.example.springbootstudy.service.impl.TestServiceImpl") // 相当于给定命名空间，命名隔离
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;


    @Override
    // @CachePut(key = "#user.id")  // 一般用在添加和更新方法上，key为了唯一性，一般用对象的主键，但是只插入会有问题，插入后userAll就不匹配了
    @Caching(   // 这个注解可以包含多个缓存操作
        put = @CachePut(key = "#user.id"),  // 添加这个User
        evict = @CacheEvict(key = "'userAll'")
    )
    public User saveUser(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    // @CacheEvict(key = "#id")  // 删除方法
    @Caching(
            evict = {
                    @CacheEvict(key = "#id"),
                    @CacheEvict(key = "'userAll'")
            }
    )
    public int removeUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    // @CachePut(key = "#user.id")
    @Caching(
            put = @CachePut(key = "#user.id"),
            evict = @CacheEvict(key = "'userAll'")
    )
    public User updateUser(User user) {
        userMapper.updateById(user);
        return user;
    }

    @Override
    @Cacheable(key = "#id")
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    @Cacheable(key = "'userAll'")  // 不加单引号会被当作变量处理
    public List<User> findAll() {
        return userMapper.selectList(new QueryWrapper<>());
    }
}

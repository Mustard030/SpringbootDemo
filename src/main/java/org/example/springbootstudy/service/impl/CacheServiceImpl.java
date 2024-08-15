package org.example.springbootstudy.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootstudy.entity.User;
import org.example.springbootstudy.myinterface.CacheNames;
import org.example.springbootstudy.service.CacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CacheServiceImpl implements CacheService {


    @Override
    @Cacheable(cacheNames = CacheNames.CACHE_5MINS, key = "#root.method.name + ':' + #id")
    public User getUser(Integer id) {
        System.out.println(LocalDateTime.now());
        return new User(id, "xiaoming");
    }
}

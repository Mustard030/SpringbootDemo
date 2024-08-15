package org.example.springbootstudy.controller;

import jakarta.annotation.Resource;
import org.example.springbootstudy.entity.User;
import org.example.springbootstudy.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Resource
    private CacheService cacheService;

    @GetMapping("/user")
    // @NotRestController
    public User getUser(@RequestParam Integer id) {
        return cacheService.getUser(id);
    }
}

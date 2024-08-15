package org.example.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {

    // @GetMapping("/refresh")
    // public RestBean<String> refreshToken(){
    //     // User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //     // String jwt = JWTUtils.createJwt(user);
    //     // return RestBean.success(jwt);
    // }
}
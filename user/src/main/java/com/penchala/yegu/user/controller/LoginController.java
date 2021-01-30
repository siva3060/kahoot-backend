package com.penchala.yegu.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.penchala.yegu.user.Service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
     UserService userService;

    @GetMapping("/login")
    public boolean userLogin(@RequestParam("userId") String userId,
                             @RequestParam("password")String password){
        log.info("authenticating user "+userId);
        return userService.authenticate(userId,password);
    }
}

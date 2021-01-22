package com.penchala.yegu.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public boolean userLogin(@RequestParam("userId") String userId,@RequestParam("password")String password){
        return true;
    }
}

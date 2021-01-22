package com.penchala.yegu.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user/healthcheck")
public class HealthCheck{
    @GetMapping
    public String  healthcheck(){
        return "KEEPALIVE_OK";
    }
}

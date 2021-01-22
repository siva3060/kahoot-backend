package com.penchala.yegu.game.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/app/game")
public class HealthCheck{
    @GetMapping("/healthcheck")
    public String  healthcheck(){
        return "KEEPALIVE_OK";
    }
}

package com.penchala.yegu.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/data")
public class HealthCheck {

    @GetMapping("/healthcheck")
    public String healthcheck(){
        return "KEEPALIVE_OK";
    }
}

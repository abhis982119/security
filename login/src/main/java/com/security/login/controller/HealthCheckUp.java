package com.security.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckUp {


    @GetMapping("checkUp")
    public String checkHealth(){
        return "heath status : ok";
    }
}

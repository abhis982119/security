package com.security.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {


    @GetMapping("/login")
    public String loginInPage(){
        return "this is login page";
    }


}

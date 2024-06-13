package com.liwx.eureka.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("/hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello World!"+authentication.getName();

    }
    @GetMapping("/hello/test")
    public String hellotest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hello World!"+authentication.getPrincipal();

    }

}
package com.kimjuls.best_practice_java_spring_boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {
    @GetMapping("/")
    public String hello() {
        return "hello world";
    }
}

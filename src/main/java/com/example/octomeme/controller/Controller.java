package com.example.octomeme.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World!") String name) {
        return String.format("Hi %s!", name);
    }

}

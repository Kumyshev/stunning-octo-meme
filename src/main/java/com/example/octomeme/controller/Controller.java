package com.example.octomeme.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.*;

@RestController
public class Controller {
    @Value("${spring.application.name}")
    private String Name;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("Name", Name);
        return "home";
    }

}

package com.example.new_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:9999")
public class MyController {

    @GetMapping("/")
    public String index() {
        return "/main";
    }

    @GetMapping("/map")
    public String map(){
        return "/map";
    }
}

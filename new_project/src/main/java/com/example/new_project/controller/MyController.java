package com.example.new_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:9999")
public class MyController {

    @Autowired


    @GetMapping("/")
    public String index() {
        return "/main";
    }

    @GetMapping("/map")
    public String map(){
        return "/map";
    }

    @GetMapping("/faq")
    public String faq(){
        return "/faq";
    }
}

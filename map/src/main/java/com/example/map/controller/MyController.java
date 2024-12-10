package com.example.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:9990")
public class MyController {

    @GetMapping("/")
    public String index() {
        return "/map";
    }

}
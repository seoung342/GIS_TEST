package com.example.map.controller;

import com.example.map.dto.Distance;
import com.example.map.dto.Position;
import com.example.map.mapper.DistanceMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = "http://localhost:9990")
@Log4j2
public class MyController {

    @GetMapping("/")
    public String index() {
        return "/map";
    }

    @Autowired
    private DistanceMapper distanceMapper;

    @PostMapping("/subway")
    public ResponseEntity<Distance> getNearestSubway(@RequestBody Position position) {
        log.info(position);
        Distance distance = distanceMapper.selectNear(position);
        log.info(distance.toString());
        return ResponseEntity.ok(distance);
    }
}

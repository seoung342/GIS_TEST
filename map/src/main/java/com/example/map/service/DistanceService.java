package com.example.map.service;

import com.example.map.dto.Distance;
import com.example.map.dto.Position;

public interface DistanceService {

    Distance selectNear(Position position);

}

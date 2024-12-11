package com.example.map.service;

import com.example.map.entity.Distance;
import com.example.map.entity.Position;

public interface DistanceService {

    Distance selectNear(Position position);

}

package com.example.map.service;

import com.example.map.dto.Distance;
import com.example.map.dto.Position;
import com.example.map.mapper.DistanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistanceServiceImpl implements DistanceService {

    private final DistanceMapper distanceMapper;

    @Override
    public Distance selectNear(Position position) {
        return distanceMapper.selectNear(position);
    }
}

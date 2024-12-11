package com.example.map.mapper;

import com.example.map.dto.Distance;
import com.example.map.dto.Position;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DistanceMapper {

    Distance selectNear(Position position);
}

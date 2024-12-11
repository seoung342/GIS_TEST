package com.example.map.mapper;

import com.example.map.entity.Distance;
import com.example.map.entity.Position;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DistanceMapper {

    Distance selectNear(Position position);
}

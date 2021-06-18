package com.desafio2.demo.mapper;

import com.desafio2.demo.model.Neighborhood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeighborhoodMapper {
    public static Map<Integer, Neighborhood> toNeighborhoodMap(List<Neighborhood> list) {
        Map<Integer, Neighborhood> map = new HashMap<>();
        for(Neighborhood dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    public static List<Neighborhood> toNeighborhoodList(Map<Integer, Neighborhood> map) {
        List<Neighborhood> list = new ArrayList<>();
        for(Map.Entry<Integer, Neighborhood> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}

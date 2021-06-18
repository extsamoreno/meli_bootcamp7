package com.example.desafio2.mappers;

import com.example.desafio2.models.NeighborhoodDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeighborhoodMapper {

    public static Map<Integer, NeighborhoodDTO> toNeighborhoodMap(List<NeighborhoodDTO> list) {
        Map<Integer, NeighborhoodDTO> map = new HashMap<>();
        for(NeighborhoodDTO dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    public static List<NeighborhoodDTO> toNeighborhoodList(Map<Integer, NeighborhoodDTO> map) {
        List<NeighborhoodDTO> list = new ArrayList<>();
        for(Map.Entry<Integer, NeighborhoodDTO> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}

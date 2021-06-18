package com.example.desafio2.mappers;

import com.example.desafio2.models.PropertyDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyMapper {

    public static Map<Integer, PropertyDTO> toPropertyMap(List<PropertyDTO> list) {
        Map<Integer, PropertyDTO> map = new HashMap<>();
        for(PropertyDTO dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    public static List<PropertyDTO> toPropertyList(Map<Integer, PropertyDTO> map) {
        List<PropertyDTO> list = new ArrayList<>();
        for(Map.Entry<Integer, PropertyDTO> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}

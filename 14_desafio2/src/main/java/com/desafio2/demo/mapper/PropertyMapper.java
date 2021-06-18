package com.desafio2.demo.mapper;

import com.desafio2.demo.model.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyMapper {
    public static Map<Integer, Property> toPropertyMap(List<Property> list) {
        Map<Integer, Property> map = new HashMap<>();
        for(Property dto : list) {
            map.put(dto.getId(), dto);
        }
        return map;
    }

    public static List<Property> toPropertyList(Map<Integer, Property> map) {
        List<Property> list = new ArrayList<>();
        for(Map.Entry<Integer, Property> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
}

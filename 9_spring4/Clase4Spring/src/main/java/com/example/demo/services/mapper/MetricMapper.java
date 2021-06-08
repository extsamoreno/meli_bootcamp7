package com.example.demo.services.mapper;

import com.example.demo.dto.LinkMetricDTO;

public class MetricMapper {

    public static LinkMetricDTO toDTO(int count){
        return new LinkMetricDTO(count);
    }
}

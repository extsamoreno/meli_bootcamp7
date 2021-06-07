package com.linktracker.demo.services.mappers;

import com.linktracker.demo.dtos.LinkMetricDTO;

public class MetricMapper {

    public static LinkMetricDTO toDTO(Integer count){
        return new LinkMetricDTO(count);
    }
}

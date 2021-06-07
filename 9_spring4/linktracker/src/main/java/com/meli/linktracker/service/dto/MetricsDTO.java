package com.meli.linktracker.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetricsDTO {

    private String url;
    private Integer numRedirections;

}

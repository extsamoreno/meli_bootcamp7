package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetricsDTO {
    private Integer totalRedirects;
    private String url;
    private Integer id;
}

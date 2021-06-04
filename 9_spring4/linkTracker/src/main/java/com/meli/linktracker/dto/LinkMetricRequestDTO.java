package com.meli.linktracker.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkMetricRequestDTO {
    private Integer LinkId;
    private Integer total;
}
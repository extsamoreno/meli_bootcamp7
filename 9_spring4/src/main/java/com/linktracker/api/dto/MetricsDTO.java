package com.linktracker.api.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class MetricsDTO {
    private String url;
    private int id;
    private int redirectCounter;
}

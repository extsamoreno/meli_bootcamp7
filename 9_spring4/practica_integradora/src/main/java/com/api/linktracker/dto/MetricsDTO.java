package com.api.linktracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetricsDTO {

    @JsonProperty("RedirectionCounter")
    private int redirectionCounter;
}

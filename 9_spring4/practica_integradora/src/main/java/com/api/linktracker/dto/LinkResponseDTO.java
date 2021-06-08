package com.api.linktracker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkResponseDTO {

    @JsonProperty("LinkId")
    private int linkId;
}

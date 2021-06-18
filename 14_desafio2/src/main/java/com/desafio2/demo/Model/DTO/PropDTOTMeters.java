package com.desafio2.demo.Model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropDTOTMeters {
    private String name;
    @JsonProperty("Total squeare meters")
    private double totalMeters;
}

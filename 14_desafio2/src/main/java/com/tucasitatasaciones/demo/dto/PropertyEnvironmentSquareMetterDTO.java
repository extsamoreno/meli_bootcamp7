package com.tucasitatasaciones.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyEnvironmentSquareMetterDTO {
    private int id;
    @JsonProperty("prop_name")
    private String name;
    private ArrayList<EnvironmentSquareMetterDTO> environments;
}

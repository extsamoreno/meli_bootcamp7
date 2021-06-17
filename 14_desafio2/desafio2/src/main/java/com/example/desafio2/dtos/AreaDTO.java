package com.example.desafio2.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaDTO {
    @JsonProperty("property ID")
    private int propId;
    @JsonProperty("total area")
    private double area;
}

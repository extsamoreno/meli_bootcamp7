package com.tucasita.tasaciones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomSquareMetersDTO {

    @JsonProperty("environment_name")
    private String name;
    @JsonProperty("environment_square_meters")
    private Double squareMeters;

    public RoomSquareMetersDTO(String name, Double squareMeters) {
        this.name = name;
        this.squareMeters = squareMeters;
    }

    public RoomSquareMetersDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }
}

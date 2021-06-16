package com.tucasita.tasaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoomDTO {

    @JsonProperty("environment_name")
    @Size(max = 30, message = "Maximum length for environment name is 30 characters")
    @NotNull
    private String name;
    @JsonProperty("environment_width")
    @NotNull
    private double width;
    @JsonProperty("environment_length")
    @NotNull
    private double length;

    public RoomDTO(String name, double width, double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public RoomDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}

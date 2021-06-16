package com.tucasita.tasaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NeighborhoodDTO {

    @JsonProperty("district_name")
    @Size(max = 45, message = "Maximum length for district name is 45 characters")
    @NotNull
    private String name;
    @JsonProperty("district_price")
    @NotNull
    private Double price;

    public NeighborhoodDTO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public NeighborhoodDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

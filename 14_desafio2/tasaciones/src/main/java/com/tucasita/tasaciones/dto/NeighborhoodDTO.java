package com.tucasita.tasaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NeighborhoodDTO {

    @JsonProperty("district_name")
    @Size(max = 45, message = "La longitud del nombre no puede superar los 45 caracteres.")
    @NotNull
    @NotEmpty(message = "El nombre del barrio no puede estar vacío.")
    private String name;

    @JsonProperty("district_price")
    @NotNull(message = "El precio de un barrio no puede estar vacío.")
    @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
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

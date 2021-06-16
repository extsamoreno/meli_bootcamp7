package com.tucasita.tasaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class RoomDTO {

    @JsonProperty("environment_name")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @NotNull
    @NotEmpty(message = "El nombre del ambiente no puede estar vacío.")
    @Pattern(regexp = "([A-Z]([a-z]*))", message = "El nombre del ambiente debe comenzar con mayúscula")
    private String name;

    @JsonProperty("environment_width")
    @NotNull(message = "El ancho del ambiente no puede estar vacío")
    @Max(value = 25, message = "El máximo ancho permitido por propiedad es de 25 mts.")
    private Double width;

    @JsonProperty("environment_length")
    @NotNull(message = "El largo del ambiente no puede estar vacío")
    @Max(value = 33, message = "El máximo largo permitido por propiedad es de 33 mts.")
    private Double length;

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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}

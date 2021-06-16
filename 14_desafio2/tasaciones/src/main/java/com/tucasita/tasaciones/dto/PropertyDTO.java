package com.tucasita.tasaciones.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tucasita.tasaciones.model.Room;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class PropertyDTO {

    @JsonProperty("prop_name")
    @NotNull
    @NotEmpty(message = "El nombre de la propiedad no puede estar vacío.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "([A-Z]([a-z]*))", message = "El nombre de la propiedad debe comenzar con mayúscula")
    private String name;

    @JsonProperty("district")
    @NotNull
    private NeighborhoodDTO neighborhood;

    @JsonProperty("environments")
    @NotNull
    private List<RoomDTO> rooms;

    public PropertyDTO(String name, NeighborhoodDTO neighborhood, List<RoomDTO> rooms) {
        this.name = name;
        this.neighborhood = neighborhood;
        this.rooms = rooms;
    }

    public PropertyDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NeighborhoodDTO getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(NeighborhoodDTO neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}

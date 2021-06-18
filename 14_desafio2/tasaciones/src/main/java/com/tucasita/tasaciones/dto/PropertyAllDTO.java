package com.tucasita.tasaciones.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyAllDTO {

    @JsonProperty("prop_name")
    private String name;
    @JsonProperty("district")
    private NeighborhoodDTO neighborhood;
    @JsonProperty("environments")
    private List<RoomDTO> rooms;

    public PropertyAllDTO(String name, NeighborhoodDTO neighborhood, List<RoomDTO> rooms) {
        this.name = name;
        this.neighborhood = neighborhood;
        this.rooms = rooms;
    }

    public PropertyAllDTO() {
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

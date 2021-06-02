package com.apiSpring3.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class BiggestRoomDTO {

    @JsonProperty("Nombre habitacion")
    private String name;

    @JsonProperty("Ancho")
    private double width;

    @JsonProperty("Largo")
    private double length;
}

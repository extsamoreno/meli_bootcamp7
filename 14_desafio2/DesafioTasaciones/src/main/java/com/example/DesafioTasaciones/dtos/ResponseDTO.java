package com.example.DesafioTasaciones.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private Double totalSquareMeters;
    private Double propertyValue;
    private RoomDTO largestEnvironment;
    private List<RoomDTO> roomsSquareMeters;

}

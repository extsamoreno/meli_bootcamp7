package com.example.DesafioTasaciones.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;
@Getter@Setter
@Data @AllArgsConstructor @NoArgsConstructor @JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private Double totalSquareMeters;
    private Double propertyValue;
    private RoomDTO largestEnvironment;
    private List<RoomDTO> roomsSquareMeters;

}

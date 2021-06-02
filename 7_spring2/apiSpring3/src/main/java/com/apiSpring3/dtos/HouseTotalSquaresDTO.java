package com.apiSpring3.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class HouseTotalSquaresDTO {

    @JsonProperty("Total Squares")
    private double totalSquares;
}

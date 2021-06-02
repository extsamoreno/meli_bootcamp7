package com.apiSpring3.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class HouseTotalValueDTO {

    @JsonProperty("Total Value")
    private double totalValue;
}

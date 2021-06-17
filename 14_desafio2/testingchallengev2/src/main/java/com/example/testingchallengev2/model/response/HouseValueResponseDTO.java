package com.example.testingchallengev2.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseValueResponseDTO {
    private String houseName;
    private Double houseValue;
}

package com.example.testingchallengev2.model.response;

import com.example.testingchallengev2.model.request.HouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewHouseResponseDTO {
    private String houseName;
    private String message;
    private HouseDTO houseDTO;
}

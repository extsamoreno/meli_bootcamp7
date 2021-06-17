package com.example.testingchallengev2.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseBiggestRoomResponseDTO {
    private String houseName;
    private String roomName;
    private Double size;
}

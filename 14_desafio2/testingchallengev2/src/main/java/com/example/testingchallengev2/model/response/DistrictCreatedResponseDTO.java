package com.example.testingchallengev2.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictCreatedResponseDTO {
    private String districtName;
    private String creationMessage;
}

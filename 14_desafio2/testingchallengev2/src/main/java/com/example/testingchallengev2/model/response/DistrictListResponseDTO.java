package com.example.testingchallengev2.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictListResponseDTO extends HashMap{
    private HashMap<String, Double> districts;
}

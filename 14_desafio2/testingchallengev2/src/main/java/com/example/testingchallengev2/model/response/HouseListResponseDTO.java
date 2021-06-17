package com.example.testingchallengev2.model.response;

import com.example.testingchallengev2.model.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseListResponseDTO extends HashMap{
    private HashMap<String, House> houses;
}

package com.example.testingchallengev2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {

    private String name;
    private String districtName;
    private ArrayList<Room> rooms;
}

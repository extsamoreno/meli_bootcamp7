package com.example.testing.databse;

import com.example.testing.model.District;
import com.example.testing.model.Property;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class DataBaseDistrict {

    public static ArrayList<District> dataBaseDistricts= new ArrayList<>(Arrays.asList(
            new District("District1", 1000.0),
            new District("District2", 1500.0)
    ));
}

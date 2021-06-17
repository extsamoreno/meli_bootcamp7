package com.example.testing.databse;

import com.example.testing.model.District;
import com.example.testing.model.Environment;
import com.example.testing.model.Property;

import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {

    public static ArrayList<Property> dataBaseProperties= new ArrayList<>(Arrays.asList(
            new Property(
                    1,
                    "House1",
                    new District("District1", 1000.0),
                    new ArrayList<Environment>(Arrays.asList(
                            new Environment("Bathroom", 4.0, 4.0),
                            new Environment("Kitchen", 6.0, 6.0),
                            new Environment("Bedroom", 5.0, 5.0),
                            new Environment("LivingRoom", 8.0, 8.0)))
            ),
            new Property(
                    2,
                    "House2",
                    new District("District2", 1500.0),
                    new ArrayList<Environment>(Arrays.asList(
                            new Environment("Bathroom", 4.0, 4.0),
                            new Environment("Kitchen", 6.0, 6.0),
                            new Environment("Bedroom", 5.0, 5.0)))
            ),
            new Property(
                    3,
                    "House3",
                    new District("District1", 1500.0),
                    new ArrayList<Environment>(Arrays.asList(
                            new Environment("Bathroom", 4.0, 4.0),
                            new Environment("Kitchen", 6.0, 6.0),
                            new Environment("Bedroom", 5.0, 5.0)))
            ),
            new Property(
                    4,
                    "House4",
                    new District("District2", 1000.0),
                    new ArrayList<Environment>(Arrays.asList(
                            new Environment("Bathroom", 4.0, 4.0),
                            new Environment("Kitchen", 6.0, 6.0),
                            new Environment("Bedroom", 5.0, 5.0),
                            new Environment("LivingRoom", 8.0, 8.0)))
            )
    ));


}

package com.testingchallenge.tucasita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    private String name; // "casa de Diego", I don't know...
    private Neighborhood neighborhood;
    private List<Room> roomList;
}


/*
{
    name,
    district: {
        name,
        price
    },
    environments: {
        env1: {
            name,
            length,
            width
        },
        env2: {
            name,
            length,
            width
        },
    }
}
*/

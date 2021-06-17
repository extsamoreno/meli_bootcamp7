package com.bootcamp.desafio2;

import com.bootcamp.desafio2.dto.request.EnvironmentDTO;
import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.entity.District;
import com.bootcamp.desafio2.entity.Environment;
import com.bootcamp.desafio2.entity.House;

import javax.validation.Valid;
import java.util.ArrayList;

public abstract class UtilsGenerator {

    public static HouseFeaturesDTO generateHouseFeaturesCasa101(){
        String prop_name = "Casa101";
        double total_area = 24.0;
        double price = 12000.0;
        EnvironmentShortDTO biggest_environment = new EnvironmentShortDTO("Room1", 15.0);
    return new HouseFeaturesDTO(prop_name, total_area, price, biggest_environment);
    }

    public static ArrayList<EnvironmentShortDTO> showEnvironmentListCasa101(){
        ArrayList<EnvironmentShortDTO> response = new ArrayList<>();
        EnvironmentShortDTO env1 = new EnvironmentShortDTO("Kitchen", 5.0);
        EnvironmentShortDTO env2 = new EnvironmentShortDTO("Room1", 15.0);
        EnvironmentShortDTO env3 = new EnvironmentShortDTO("Bath Room", 4.0);

        response.add(env1);
        response.add(env2);
        response.add(env3);

        return response;
    }

    public static HouseDTO generateNewHouseDTO(){
        String prop_name = "Apto101";
        String district_name = "Palermo";
        ArrayList<EnvironmentDTO> environments = new ArrayList<>();

        EnvironmentDTO env1 = new EnvironmentDTO("Kitchen", 2.5, 2.0);
        EnvironmentDTO env2 = new EnvironmentDTO("Room1", 5.0, 3.0);
        EnvironmentDTO env3 = new EnvironmentDTO("Bath Room", 2.0, 2.0);
        environments.add(env1);
        environments.add(env2);
        environments.add(env3);

        return new HouseDTO(prop_name, district_name, environments);
    }

    public static House genererateHouse(){
        String prop_name = "Casa101";
        District district = new District("Santa Fe", 500.0);
        ArrayList<Environment> environments = new ArrayList<>();

        Environment env1 = new Environment("Kitchen", 2.5, 2.0);
        Environment env2 = new Environment("Room1", 5.0, 3.0);
        Environment env3 = new Environment("Bath Room", 2.0, 2.0);
        environments.add(env1);
        environments.add(env2);
        environments.add(env3);

        return new House(prop_name, district, environments);
    }


/*
    {
        "prop_name" : "Casa101",
            "district" : {
        "district_name": "Santa Fe",
                "district_price": 500.0
    },
        "environments" : [
        {
            "environment_name" : "Kitchen",
                "environment_width" : 2.5,
                "environment_length" : 2.0
        },
        {
            "environment_name" : "Room1",
                "environment_width" : 5.0,
                "environment_length" : 3.0
        },
        {
            "environment_name" : "Bath Room",
                "environment_width" : 2.0,
                "environment_length" : 2.0
        }
                      ]
    },
    /*
    {
        "prop_name": "Apto101",
            "district_name": "Palermo",
            "environments": [
        {
            "environment_name": "Kitchen",
                "environment_width": 2.5,
                "environment_length": 2.0
        },
        {
            "environment_name": "Room1",
                "environment_width": 5.0,
                "environment_length": 3.0
        },
        {
            "environment_name": "Bath Room",
                "environment_width": 2.0,
                "environment_length": 2.0
        }
    ]
    }


/*
    {
        "prop_name": "Casa101",
            "total_area": 24.0,
            "price": 12000.0,
            "biggest_environment": {
        "environment_name": "Room1",
                "environment_area": 15.0
    }
    }

    [
    {
        "environment_name": "Kitchen",
            "environment_area": 5.0
    },
    {
        "environment_name": "Room1",
            "environment_area": 15.0
    },
    {
        "environment_name": "Bath Room",
            "environment_area": 4.0
    }
]

 */
}

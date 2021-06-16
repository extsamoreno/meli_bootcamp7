package com.bootcamp.desafio2.service;

import com.bootcamp.desafio2.dto.PropertyDTO;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements IPropertyService{


    @Override
    public PropertyDTO calculateFeatures(String prop_name) {

        return new PropertyDTO("Casa1", 300, 100);
    }



    /*
    private void calculateEnvironmentArea(PropertyDTO propertyDTO) {
        Integer totalSquareFeet = 0;
        RoomDTO biggest = null;
        Integer maxRoom = 0;
        for (RoomDTO room : house.getRooms()) {
            Integer squareFeet = room.getSquareFeet();
            totalSquareFeet += squareFeet;
            if (biggest == null || squareFeet > maxRoom){
                biggest = room;
                maxRoom = squareFeet;
            }
        }
        response.setSquareFeet(totalSquareFeet);
        response.setBiggest(biggest);
    }

     */

}

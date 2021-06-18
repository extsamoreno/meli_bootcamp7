package com.meli.desafio2;

import com.meli.desafio2.dto.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static PropertyDTO PropertyHappy(String name){
        PropertyDTO property = new PropertyDTO(
                1,
                name,
                1,
                new ArrayList<EnvironmentDTO>(environmentListHappy())
        );
        return property;
    }

    public static PropertyInputDTO propertyInputHappy(String name){
        PropertyInputDTO property = new PropertyInputDTO(
                name,
                districtInputHappy("Amber"),
                new ArrayList<EnvironmentDTO>(environmentListHappy())
        );
        return property;
    }

    public static PropertyFullDTO propertyFullHappy(String name){
        PropertyFullDTO property = new PropertyFullDTO(
                1,
                name,
                districtHappy("Amber"),
                environmentListHappy()
        );
        return property;
    }

    public static PropertySquareDTO propertySquareHappy(String name){
        return new PropertySquareDTO(1,name,110);
    }

    public static PropertyValueDTO propertyValueHappy(String name) {
        return new PropertyValueDTO(1,name,11000);
    }

    public static PropertyBiggestEnvironmentDTO propertyBiggestEnvironmentHappy(String name) {
        return new PropertyBiggestEnvironmentDTO(1,name,new EnvironmentSquareDTO("Living",8,6,48));
    }

    public static PropertyAllSquareDTO propertyAllSquareHappy(String name) {
        return new PropertyAllSquareDTO(1,name,environmentSquareListHappy());
    }

    public static DistrictInputDTO districtInputHappy(String name){
        return new DistrictInputDTO(name,100.0);
    }

    public static DistrictDTO districtHappy(String name){
        return new DistrictDTO(1,name,100.0);
    }

    public static ArrayList<EnvironmentDTO> environmentListHappy(){
        EnvironmentDTO[] environmentArr = {
                new EnvironmentDTO("Cocina",6,7),
                new EnvironmentDTO("Dormitorio",4,5),
                new EnvironmentDTO("Living",8,6)};
        ArrayList<EnvironmentDTO> environmentList = new ArrayList<>();
        environmentList.addAll(Arrays.asList(environmentArr));
        return environmentList;
    }

    public static ArrayList<EnvironmentSquareDTO> environmentSquareListHappy(){
        EnvironmentSquareDTO[] environmentArr = {
                new EnvironmentSquareDTO("Cocina",6,7,42),
                new EnvironmentSquareDTO("Dormitorio",4,5.,20),
                new EnvironmentSquareDTO("Living",8,6,48)};
        ArrayList<EnvironmentSquareDTO> environmentList = new ArrayList<>();
        environmentList.addAll(Arrays.asList(environmentArr));
        return environmentList;
    }
}

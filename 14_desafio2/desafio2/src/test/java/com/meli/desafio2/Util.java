package com.meli.desafio2;

import com.meli.desafio2.dto.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static PropertyInputDTO PropertyInputHappy(String name){
        PropertyInputDTO property = new PropertyInputDTO(
                name,
                districtInputHappy("Amber"),
                new ArrayList<EnviromentDTO>(enviromentListHappy())
        );
        return property;
    }

    public static PropertyFullDTO PropertyFullHappy(String name){
        PropertyFullDTO property = new PropertyFullDTO(
                1,
                name,
                districtHappy("Amber"),
                enviromentListHappy()
        );
        return property;
    }

    public static PropertySquareDTO propertySquareHappy(String name){
        return new PropertySquareDTO(1,name,110);
    }

    public static PropertyValueDTO propertyValueHappy(String name) {
        return new PropertyValueDTO(1,name,11000);
    }

    public static PropertyBiggestEnviromentDTO propertyBiggestEnviromentHappy(String name) {
        return new PropertyBiggestEnviromentDTO(1,name,new EnviromentSquareDTO("Cocina",6,7,42));
    }

    public static PropertyAllSquareDTO propertyAllSquareHappy(String name) {
        return new PropertyAllSquareDTO(1,name,enviromentSquareListHappy());
    }

    public static DistrictInputDTO districtInputHappy(String name){
        return new DistrictInputDTO(name,100.0);
    }

    public static DistrictDTO districtHappy(String name){
        return new DistrictDTO(1,name,100.0);
    }

    public static ArrayList<EnviromentDTO> enviromentListHappy(){
        EnviromentDTO[] enviromentArr = {
                new EnviromentDTO("Cocina",6,7),
                new EnviromentDTO("Dormitorio",4,5),
                new EnviromentDTO("Living",8,6)};
        ArrayList<EnviromentDTO> enviromentList = new ArrayList<>();
        enviromentList.addAll(Arrays.asList(enviromentArr));
        return enviromentList;
    }

    public static ArrayList<EnviromentSquareDTO> enviromentSquareListHappy(){
        EnviromentSquareDTO[] enviromentArr = {
                new EnviromentSquareDTO("Cocina",6,7,42),
                new EnviromentSquareDTO("Dormitorio",4,5.,20),
                new EnviromentSquareDTO("Living",8,6,48)};
        ArrayList<EnviromentSquareDTO> enviromentList = new ArrayList<>();
        enviromentList.addAll(Arrays.asList(enviromentArr));
        return enviromentList;
    }
}

package com.example.ChallengeTwo.Util;

import com.example.ChallengeTwo.dto.BiggestEnvironmentDTO;
import com.example.ChallengeTwo.dto.DistrictDTO;
import com.example.ChallengeTwo.dto.EnvironmentAreaDTO;
import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.model.District;
import com.example.ChallengeTwo.model.Environment;
import com.example.ChallengeTwo.model.House;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {
    public static HouseDTO getHouseDTOWith4Environments(String houseName, String districName){
        Environment e1 = new Environment("living-room",6.3,3.2);
        Environment e2 = new Environment("bedroom main",4.3,3.0);
        Environment e3 = new Environment("dinnerroom",2.5,2.2);
        Environment e4 = new Environment("kitchen",2.8,1.2);

        List<Environment> listEnvironments = new ArrayList<>();
        listEnvironments.add(e1);listEnvironments.add(e2);listEnvironments.add(e3);listEnvironments.add(e4);

        HouseDTO houseResult = new HouseDTO(houseName,districName,listEnvironments);
        return houseResult;
    }
    public static House getHouseWith4Environments(String houseName){
        Environment e1 = new Environment("living-room",6.3,3.2);
        Environment e2 = new Environment("bedroom main",4.0,3.0);
        Environment e3 = new Environment("dinnerroom",2.5,2.2);
        Environment e4 = new Environment("kitchen",2.8,1.2);

        List<Environment> listEnvironments = new ArrayList<>();
        listEnvironments.add(e1);listEnvironments.add(e2);listEnvironments.add(e3);listEnvironments.add(e4);
        District district = new District("center",1200);

        House houseResult = new House(houseName,district,listEnvironments);
        return houseResult;
    }
    public static List<EnvironmentAreaDTO> getListENvironmentDTO(){
        EnvironmentAreaDTO e1 = new EnvironmentAreaDTO("living-room",20.16);
        EnvironmentAreaDTO e2 = new EnvironmentAreaDTO("bedroom main",12.0);
        EnvironmentAreaDTO e3 = new EnvironmentAreaDTO("dinnerroom",5.5);
        EnvironmentAreaDTO e4 = new EnvironmentAreaDTO("kitchen",3.36);


        List<EnvironmentAreaDTO> listResult = new ArrayList<>();
        listResult.add(e1);listResult.add(e2);listResult.add(e3);listResult.add(e4);

        return listResult;
    }
    public static BiggestEnvironmentDTO getBiggerEnvironmentDTO(String houseName,String environmentName){
        BiggestEnvironmentDTO result = new BiggestEnvironmentDTO(houseName,environmentName,20.16);
        return result;
    }

}

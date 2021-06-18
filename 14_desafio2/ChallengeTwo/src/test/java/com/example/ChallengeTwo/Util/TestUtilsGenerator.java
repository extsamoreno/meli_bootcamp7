package com.example.ChallengeTwo.Util;

import com.example.ChallengeTwo.dto.DistrictDTO;
import com.example.ChallengeTwo.dto.EnvironmentAreaDTO;
import com.example.ChallengeTwo.dto.HouseDTO;
import com.example.ChallengeTwo.model.Environment;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {
    public static HouseDTO getHouseWith4Environments(String houseName, String districName){
        Environment e1 = new Environment("living-room",6.3,3.2);
        Environment e2 = new Environment("bedroom main",4.3,3.0);
        Environment e3 = new Environment("dinnerroom",2.5,2.2);

        List<Environment> listEnvironments = new ArrayList<>();
        listEnvironments.add(e1);listEnvironments.add(e2);listEnvironments.add(e3);

        HouseDTO houseResult = new HouseDTO(houseName,districName,listEnvironments);
        return houseResult;
    }
    public static List<EnvironmentAreaDTO> getListENvironmentDTO(){
        EnvironmentAreaDTO e1 = new EnvironmentAreaDTO("living-room",43.2);
        EnvironmentAreaDTO e2 = new EnvironmentAreaDTO("bedroom main",24.3);

        List<EnvironmentAreaDTO> listResult = new ArrayList<>();
        listResult.add(e1);listResult.add(e2);

        return listResult;
    }

}

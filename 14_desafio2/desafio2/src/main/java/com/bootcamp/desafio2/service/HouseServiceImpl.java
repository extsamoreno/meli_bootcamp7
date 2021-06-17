package com.bootcamp.desafio2.service;

import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.model.Environment;
import com.bootcamp.desafio2.model.House;
import com.bootcamp.desafio2.repository.district.IDistrictRepository;
import com.bootcamp.desafio2.repository.house.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private IHouseRepository houseRepository;

    @Autowired
    private IDistrictRepository districtRepository;

    @Override
    public HouseFeaturesDTO calculateFeatures(String prop_name) throws HouseNotFoundException, DistrictNotFoundException {

        // Get the complete property with the name
        House currentHouse = houseRepository.findHouseByPropName(prop_name);

        // Validate that the district exist in the Data Base
        districtRepository.existsDistrictInDB(currentHouse.getDistrict().getDistrict_name());

        // Variables to create the response
        String name = currentHouse.getProp_name();
        double totalArea = 0;
        double biggestArea = 0;
        EnvironmentShortDTO biggestEnvironment = null;

        for (Environment room : currentHouse.getEnvironments()) {
            EnvironmentShortDTO actualEnv = createEnvironmentDTO(room);
            double actualArea = actualEnv.getEnvironment_area();

            totalArea += actualArea;
            if( biggestEnvironment == null || actualArea > biggestArea ){
                biggestEnvironment = actualEnv;
                biggestArea = actualArea;
            }
        }
        double price =  totalArea * currentHouse.getDistrict().getDistrict_price();
        return new HouseFeaturesDTO(name, totalArea, price, biggestEnvironment);
    }


    @Override
    public ArrayList<EnvironmentShortDTO> generateEnvironmentList(String prop_name) throws HouseNotFoundException {
        // Get the complete property with the name
        House currentHouse = houseRepository.findHouseByPropName(prop_name);
        ArrayList<EnvironmentShortDTO> environments = new ArrayList<>();

        // Validate that the district exist in the Data Base
        //districtRepository.existsDistrictInDB(currentHouse.getDistrict().getDistrict_name());

        for (Environment room : currentHouse.getEnvironments()) {
            EnvironmentShortDTO actualEnv = createEnvironmentDTO(room);
            environments.add(actualEnv);
        }
        return environments;
    }

    @Override
    public void addNewProperty(HouseDTO houseDTO) {

    }

    private EnvironmentShortDTO createEnvironmentDTO(Environment environment){
        double area = environment.getEnvironment_length() * environment.getEnvironment_width();
        return new EnvironmentShortDTO(environment.getEnvironment_name(), area);
    }


}

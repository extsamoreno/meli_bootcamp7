package com.bootcamp.desafio2.service;

import com.bootcamp.desafio2.dto.request.DistrictDTO;
import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.entity.District;
import com.bootcamp.desafio2.entity.Environment;
import com.bootcamp.desafio2.entity.House;
import com.bootcamp.desafio2.repository.district.IDistrictRepository;
import com.bootcamp.desafio2.repository.house.IHouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private IHouseRepository houseRepository;

    @Autowired
    private IDistrictRepository districtRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public HouseFeaturesDTO calculateFeatures(String prop_name) throws HouseNotFoundException, DistrictNotFoundException {

        // Validate that the prop_name exist in the Data Base
        if( houseRepository.existsPropertyName(prop_name) ){

            // Get the complete property with the name
            House currentHouse = houseRepository.findHouseByPropName(prop_name);
            String district_name = currentHouse.getDistrict().getDistrict_name();

            // Validate that the district exist in the Data Base
            if ( districtRepository.existsDistrictInDB(district_name) ){

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
            else
                throw new DistrictNotFoundException(district_name);
        }
        else
            throw new HouseNotFoundException(prop_name);
    }


    @Override
    public ArrayList<EnvironmentShortDTO> generateEnvironmentList(String prop_name) throws HouseNotFoundException {
        // Validate that the prop_name exist in the Data Base
        if( houseRepository.existsPropertyName(prop_name) ){

            // Get the complete property with the name
            House currentHouse = houseRepository.findHouseByPropName(prop_name);
            ArrayList<EnvironmentShortDTO> environments = new ArrayList<>();

            for (Environment room : currentHouse.getEnvironments()) {
                EnvironmentShortDTO actualEnv = createEnvironmentDTO(room);
                environments.add(actualEnv);
            }
            return environments;
        }
        else
            throw new HouseNotFoundException(prop_name);
    }

    @Override
    public void addNewProperty(HouseDTO houseDTO) throws DistrictNotFoundException, HouseAlreadyExistsException {

        // Validate that the prop_name do not exist already
        String prop_name = houseDTO.getProp_name();
        if( ! houseRepository.existsPropertyName(prop_name) ){

            // Validate that the district exist in the Data Base and the prop_name do not exist already
            String district_name = houseDTO.getDistrict_name();
            if ( districtRepository.existsDistrictInDB(district_name) ){

                // Map HouseDTO to House
                House newHouse = mapper.map(houseDTO, House.class);
                Double district_price = districtRepository.getDistrictPrice(district_name);
                DistrictDTO districtDTO = new DistrictDTO(district_name, district_price);
                District district = mapper.map(districtDTO, District.class);
                newHouse.setDistrict(district);

                // Call the method to save in the Data Base
                houseRepository.saveNewProperty(newHouse);
            }
            else
                throw new DistrictNotFoundException(district_name);
        }
        else
            throw new HouseAlreadyExistsException(prop_name);
    }


    private EnvironmentShortDTO createEnvironmentDTO(Environment environment){
        double area = environment.getEnvironment_length() * environment.getEnvironment_width();
        return new EnvironmentShortDTO(environment.getEnvironment_name(), area);
    }


}

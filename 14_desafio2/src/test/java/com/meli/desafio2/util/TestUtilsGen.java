package com.meli.desafio2.util;

import com.meli.desafio2.dto.environment.EnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalAreaDTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.model.District;
import com.meli.desafio2.model.Environment;
import com.meli.desafio2.model.Property;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGen {

    // Returns a property
    public static PropertyDTO getPropDTOWithId(Integer propId) {

        PropertyDTO prop1 = new PropertyDTO();
        prop1.setId(propId);
        prop1.setName("House");
        List<EnvironmentDTO> environments1 = new ArrayList<>();

        prop1.setDistrictId(0);
        environments1.add(new EnvironmentDTO("Room 1", 20.0, 30.0));
        environments1.add(new EnvironmentDTO("Room 2", 25.0, 20.0));
        environments1.add(new EnvironmentDTO("Room 3", 10.0, 10.0));
        prop1.setEnvironments(environments1);

        return prop1;
    }

    // Returns a property
    public static Property getPropWithId(Integer propId) {

        Property prop1 = new Property();
        prop1.setId(propId);
        prop1.setName("House");
        List<Environment> environments1 = new ArrayList<>();

        prop1.setDistrictId(0);
        environments1.add(new Environment("Room 1", 20.0, 30.0));
        environments1.add(new Environment("Room 2", 25.0, 20.0));
        environments1.add(new Environment("Room 3", 10.0, 10.0));
        prop1.setEnvironments(environments1);

        return prop1;
    }

    // Returns a district
    public static District getDistWithId(Integer distId) {
        return new District(distId, "District", 150.0);
    }

    // Returns a ResponsePropTotalAreaDTO
    public static ResponsePropTotalAreaDTO getResponsePropTotalAreaDTO(Integer propId){
        return new ResponsePropTotalAreaDTO(propId, "House", 1200.0);
    }

    // Returns a ResponsePropValueDTO
    public static ResponsePropValueDTO getResponsePropValueDTO(Integer propId){
        return new ResponsePropValueDTO(propId, "House", 180000.0);
    }

    // Returns a ResponseBigEnvironmentDTO
    public static ResponseBigEnvironmentDTO getResponseBigEnvironmentDTO(){
        return new ResponseBigEnvironmentDTO("Room 1", 20.0, 30.0);
    }

    // Returns a List<ResponseEnvironmentDTO>
    public static List<ResponseEnvironmentDTO> getListResponseEnvironmentDTO(){

        List<ResponseEnvironmentDTO> listEnv = new ArrayList<>();

        listEnv.add(new ResponseEnvironmentDTO("Room", 10.0, 10.0, 100.0));
        listEnv.add(new ResponseEnvironmentDTO("Garden", 15.0, 15.0, 225.0));

        return listEnv;
    }
}

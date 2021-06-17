package com.meli.desafio2.util;

import com.meli.desafio2.dto.environment.EnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseBigEnvironmentDTO;
import com.meli.desafio2.dto.environment.ResponseEnvironmentDTO;
import com.meli.desafio2.dto.property.PropertyDTO;
import com.meli.desafio2.dto.property.ResponsePropTotalM2DTO;
import com.meli.desafio2.dto.property.ResponsePropValueDTO;
import com.meli.desafio2.model.District;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGen {

    // Returns a property
    public static PropertyDTO getPropWithId(Integer propId) {

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

    // Returns a district
    public static District getDistWithId(Integer distId) {
        return new District(distId, "District", 150.0);
    }

    // Returns a ResponsePropTotalM2DTO
    public static ResponsePropTotalM2DTO getResponsePropTotalM2DTO(Integer propId){
        return new ResponsePropTotalM2DTO(propId, "House", 500.0);
    }

    // Returns a ResponsePropValueDTO
    public static ResponsePropValueDTO getResponsePropValueDTO(Integer propId){
        return new ResponsePropValueDTO(propId, "House", 100000.0);
    }

    // Returns a ResponseBigEnvironmentDTO
    public static ResponseBigEnvironmentDTO getResponseBigEnvironmentDTO(){
        return new ResponseBigEnvironmentDTO("House", 10.0, 20.0);
    }

    // Returns a List<ResponseEnvironmentDTO>
    public static List<ResponseEnvironmentDTO> getListResponseEnvironmentDTO(){

        List<ResponseEnvironmentDTO> listEnv = new ArrayList<>();

        listEnv.add(new ResponseEnvironmentDTO("Room", 10.0, 10.0, 100.0));
        listEnv.add(new ResponseEnvironmentDTO("Garden", 15.0, 15.0, 225.0));

        return listEnv;
    }
}

package desafio2.testing.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import desafio2.testing.domian.District;
import desafio2.testing.domian.EnvironmentHouse;
import desafio2.testing.domian.House;
import desafio2.testing.service.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Generator {

    static ObjectMapper mapper = new ObjectMapper();

    public static House house(){
        EnvironmentHouse e1 = new EnvironmentHouse("Bath", 2.0,2.0);
        EnvironmentHouse e2 = new EnvironmentHouse("Room", 6.0,6.0);
        EnvironmentHouse e3 = new EnvironmentHouse("Yard", 15.0,20.0);
        List<EnvironmentHouse> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);

        return new House(1,"House1", new District(1, "Center", 500.0), eList1);
    }

    public static HouseDTO houseDTOIntegration(){
        EnvironmentHouseDTO e1 = new EnvironmentHouseDTO("Bath", 2.0,2.0);
        EnvironmentHouseDTO e2 = new EnvironmentHouseDTO("Room", 6.0,6.0);
        EnvironmentHouseDTO e3 = new EnvironmentHouseDTO("Yard", 15.0,20.0);
        List<EnvironmentHouseDTO> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);

        return new HouseDTO(1,"House1", new DistrictDTO(1, "Center", 500.0), eList1);
    }

    public static HouseDTO houseHappy(){
        EnvironmentHouseDTO e1 = new EnvironmentHouseDTO("Bath", 2.0,2.0);
        EnvironmentHouseDTO e2 = new EnvironmentHouseDTO("Room", 6.0,6.0);
        EnvironmentHouseDTO e3 = new EnvironmentHouseDTO("Yard", 15.0,20.0);
        List<EnvironmentHouseDTO> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);

        return new HouseDTO(5,"House5", new DistrictDTO(1, "Center", 500.0), eList1);
    }


    public static HouseDTO houseDistrictNotExist(){
        EnvironmentHouseDTO e1 = new EnvironmentHouseDTO("Bath", 2.0,2.0);
        EnvironmentHouseDTO e2 = new EnvironmentHouseDTO("Room", 6.0,6.0);
        EnvironmentHouseDTO e3 = new EnvironmentHouseDTO("Yard", 15.0,20.0);
        List<EnvironmentHouseDTO> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);

        return new HouseDTO(6,"House6", new DistrictDTO(5, "Guadalupe", 200.0), eList1);
    }


    public static HouseMeterPropertyDTO getArea(){
        return new HouseMeterPropertyDTO("House1", 340); //2*2 + 6*6 + 15*20
    }

    public static HousePriceDTO housePriceDTO(){
        return new HousePriceDTO("House1", 170000);
    }

    public static HouseLargestEnvironmentDTO houseLargestEnvironmentDTO(){
        return new HouseLargestEnvironmentDTO("House1", new EnvironmentHouse("Yard", 15.0,20.0), 300);
    }

    public static HouseMeterPerEnvironmentDTO houseMeterPerEnvironmentDTO(){
        HashMap<String, Double> meterPerEnvironment = new HashMap<>();
        meterPerEnvironment.put("Bath", 4.0);
        meterPerEnvironment.put("Room", 36.0);
        meterPerEnvironment.put("Yard", 300.0);

        return new HouseMeterPerEnvironmentDTO("House1" , meterPerEnvironment);
    }


    public static <T> String toJson(T object) throws JsonProcessingException {
        ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false). writer().withDefaultPrettyPrinter();
        return writer.writeValueAsString(object);
    }

}

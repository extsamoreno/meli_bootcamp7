package desafio2.testing.util;

import desafio2.testing.domian.District;
import desafio2.testing.domian.EnvironmentHouse;
import desafio2.testing.domian.House;
import desafio2.testing.service.dto.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Generator {

    public static House house(){
        EnvironmentHouse e1 = new EnvironmentHouse("bath", 2.0,2.0);
        EnvironmentHouse e2 = new EnvironmentHouse("room", 6.0,6.0);
        EnvironmentHouse e3 = new EnvironmentHouse("yard", 15.0,20.0);
        List<EnvironmentHouse> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);

        return new House(1,"house1", new District(1, "center", 500.0), eList1);
    }



    public static HouseDTO houseHappy(){
        EnvironmentHouseDTO e1 = new EnvironmentHouseDTO("bath", 2.0,2.0);
        EnvironmentHouseDTO e2 = new EnvironmentHouseDTO("room", 6.0,6.0);
        EnvironmentHouseDTO e3 = new EnvironmentHouseDTO("yard", 15.0,20.0);
        List<EnvironmentHouseDTO> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);

        return new HouseDTO(5,"house1", new DistrictDTO(1, "center", 500.0), eList1);
    }


    public static HouseDTO houseDistrictNotExist(){
        EnvironmentHouseDTO e1 = new EnvironmentHouseDTO("bath", 2.0,2.0);
        EnvironmentHouseDTO e2 = new EnvironmentHouseDTO("room", 6.0,6.0);
        EnvironmentHouseDTO e3 = new EnvironmentHouseDTO("yard", 15.0,20.0);
        List<EnvironmentHouseDTO> eList1 = new ArrayList<>();
        eList1.add(e1);
        eList1.add(e2);
        eList1.add(e3);

        return new HouseDTO(6,"house1", new DistrictDTO(5, "Guadalupe", 200.0), eList1);
    }


    public static HouseMeterPropertyDTO getArea(){
        return new HouseMeterPropertyDTO("house1", 340); //2*2 + 6*6 + 15*20
    }

    public static HousePriceDTO housePriceDTO(){
        return new HousePriceDTO("house1", 170000);
    }

    public static HouseLargestEnvironmentDTO houseLargestEnvironmentDTO(){
        return new HouseLargestEnvironmentDTO("house1", new EnvironmentHouse("yard", 15.0,20.0), 340);
    }

    public static HouseMeterPerEnvironmentDTO houseMeterPerEnvironmentDTO(){
        HashMap<String, Double> meterPerEnvironment = new HashMap<>();
        meterPerEnvironment.put("Bath", 4.0);
        meterPerEnvironment.put("Room", 36.0);
        meterPerEnvironment.put("Yard", 300.0);

        return new HouseMeterPerEnvironmentDTO("house1" , meterPerEnvironment);
    }

}

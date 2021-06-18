package com.meli.tu_casita.util;

import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.Environment;
import com.meli.tu_casita.model.RealState;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.model.dto.EnvironmentDTO;
import com.meli.tu_casita.model.dto.RealStateInDTO;
import com.meli.tu_casita.model.dto.RealStateOutDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestUtilGenerator {

    public static District getDistrictTest() {
        return new District(1, "District Test", 100f);
    }

    public static RealState getRealState() {
        return new RealState(1, "casa test", 1);
    }

    public static RealStateInDTO getRealStateInDTO() {
        return new RealStateInDTO("casa test", 1, getEnvironmentDTOListTest());
    }

    public static RealStateOutDTO getRealStateOutDTO() {
        return new RealStateOutDTO(1, "casa 1", getDistrictDTO(), getEnvironmentDTOListTest(), 50, 25000);
    }

    public static List<RealStateOutDTO> getRealStateOutDTOList() {
        List<RealStateOutDTO> realStateOutDTOList = new ArrayList<>();
        realStateOutDTOList.add(new RealStateOutDTO(1, "casa 1", getDistrictDTO(), getEnvironmentDTOListTest(), 50, 25000));
        realStateOutDTOList.add(new RealStateOutDTO(2, "casa 2", getDistrictDTO(), getEnvironmentDTOListTest(), 50, 25000));
        realStateOutDTOList.add(new RealStateOutDTO(3, "casa 3", getDistrictDTO(), getEnvironmentDTOListTest(), 50, 25000));
        return realStateOutDTOList;
    }

    public static EnvironmentDTO getEnvironmentDTOTest() {
        return new EnvironmentDTO(11, "Kitchen", 3f, 3f, 9f, false);
    }

    public static Environment getEnvironmentTest() {
        return new Environment(11, 1, "Kitchen", 3f, 3f);
    }

    public static List<Environment> getEnvironmentListTest() {
        List<Environment> environmentList = new ArrayList<>();
        environmentList.add(new Environment(1, 1, "Kitchen", 3f, 3f));
        environmentList.add(new Environment(2, 1, "Main Room", 4f, 4f));
        environmentList.add(new Environment(3, 1, "Living Room", 5f, 5f));
        return environmentList;
    }


    public static List<EnvironmentDTO> getEnvironmentDTOListTest() {
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        environmentDTOList.add(new EnvironmentDTO(1 , "Kitchen", 3f, 3f, 9f, false));
        environmentDTOList.add(new EnvironmentDTO(2 , "Main Room", 4f, 4f, 16f, false));
        environmentDTOList.add(new EnvironmentDTO(3 , "Living Room", 5f, 5f, 25f, true));
        return environmentDTOList;
    }

    public static List<DistrictDTO> getDistrictDTOListTest() {
        List<DistrictDTO> districtDTOList = new ArrayList<>();
        districtDTOList.add(new DistrictDTO(1, "District Test 1", 100f));
        districtDTOList.add(new DistrictDTO(1, "District Test 2", 200f));
        districtDTOList.add(new DistrictDTO(1, "District Test 3", 300f));
        return districtDTOList;
    }

    public static List<District> getDistrictListTest() {
        List<District> districtList = new ArrayList<>();
        districtList.add(new District(1, "District Test 1", 100f));
        districtList.add(new District(1, "District Test 2", 200f));
        districtList.add(new District(1, "District Test 3", 300f));
        return districtList;
    }

    public static DistrictDTO getDistrictDTO() {
        return new DistrictDTO(1, "District Test", 500f);
    }

    public static District getDistrict() {
        return new District(1, "District Test", 500f);
    }

    public static Optional<District> getOptionalDistrict() {
        return Optional.of(getDistrict());
    }

}

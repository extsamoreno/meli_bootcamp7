package com.meli.tu_casita.util;

import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.Environment;
import com.meli.tu_casita.model.RealState;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.model.dto.EnvironmentDTO;
import com.meli.tu_casita.model.dto.RealStateInDTO;
import com.meli.tu_casita.model.dto.RealStateOutDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class TestUtilGenerator {

    private static String SCOPE;


    public static District getDistrictTest() {
        return new District(1, "District Test", 100f);
    }

    public static RealState getRealState() {
        return new RealState(1, "Casa test", 1);
    }

    public static RealStateInDTO getRealStateInDTO() {
        return new RealStateInDTO("Casa 1", 1, getEnvironmentDTOListTest());
    }

    public static RealStateOutDTO getRealStateOutDTO() {
        return new RealStateOutDTO(1, "Casa 1", getDistrictDTO(), getEnvironmentDTOListTest(), 50, 25000);
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
        environmentDTOList.add(new EnvironmentDTO(1, "Kitchen", 3f, 3f, 9f, false));
        environmentDTOList.add(new EnvironmentDTO(2, "Main Room", 4f, 4f, 16f, false));
        environmentDTOList.add(new EnvironmentDTO(3, "Living Room", 5f, 5f, 25f, true));
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

    public static void emptyFile(String filename) {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/" + filename + ".json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static List<RealState> getRealStateList() {
        List<RealState> realStateList = new ArrayList<>();
        realStateList.add(new RealState(1, "Casa test 1", 1));
        realStateList.add(new RealState(2, "Casa test 2", 1));
        realStateList.add(new RealState(3, "Casa test 3", 1));
        return realStateList;
    }
}

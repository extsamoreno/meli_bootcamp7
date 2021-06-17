package com.example.challenge_2.Util;

import com.example.challenge_2.models.District;
import com.example.challenge_2.models.Environment;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.service.dto.DistrictDTO;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import com.example.challenge_2.service.dto.EnvironmentSquareMetersDTO;
import com.example.challenge_2.service.dto.PropertyDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtilsGenerator {

    public static Property getPropertyWithFourEnvironmentTest() {
        return new Property(1, "Genaro's House", getDistrictTest(), getEnvironmentListTest());
    }

    public static PropertyDTO getPropertyDTOWithFourEnvironmentTest() {
        return new PropertyDTO("Genaro's House", new DistrictDTO("Centro"), getEnvironmentDTOList());
    }

    public static District getDistrictTest() {
        return new District("Centro", 10d);
    }

    public static Environment getEnvironmentTest() {
        return new Environment("Kitchen", 30d, 5d);
    }

    public static List<Environment> getEnvironmentListTest() {

        List<Environment> environmentList = new ArrayList<>();

        environmentList.add(new Environment("Room", 7d, 5d));

        environmentList.add(new Environment("Kitchen", 30d, 5d));

        environmentList.add(new Environment("Living", 5d, 5d));

        environmentList.add(new Environment("Bathroom", 20d, 5d));

        return environmentList;
    }

    public static List<EnvironmentDTO> getEnvironmentDTOList() {

        List<EnvironmentDTO> environmentList = new ArrayList<>();

        environmentList.add(new EnvironmentDTO("Room", 7d, 5d));

        environmentList.add(new EnvironmentDTO("Kitchen", 30d, 5d));

        environmentList.add(new EnvironmentDTO("Living", 5d, 5d));

        environmentList.add(new EnvironmentDTO("Bathroom", 20d, 5d));

        return environmentList;
    }

    public static List<EnvironmentSquareMetersDTO> getEnvironmentSquareMetersDTOTest() {
        return getEnvironmentDTOList().stream().map(x -> new EnvironmentSquareMetersDTO(x.getName(), (x.getHeight() * x.getWidth()))).collect(Collectors.toList());
    }
}

package com.example.challenge_2.Util;

import com.example.challenge_2.models.District;
import com.example.challenge_2.models.Environment;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.service.dto.DistrictDTO;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import com.example.challenge_2.service.dto.EnvironmentSquareMetersDTO;
import com.example.challenge_2.service.dto.PropertyDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtilsGenerator {

    public static Property getPropertyWithFourEnvironmentTest() {
        return new Property(1, "House", getDistrictTest(), getEnvironmentListTest());
    }

    public static PropertyDTO getPropertyDTOWithFourEnvironmentTest() {
        return new PropertyDTO("House", new DistrictDTO("Centro"), getEnvironmentDTOList());
    }

    public static District getDistrictTest() {
        return new District("Centro", 10d);
    }

    public static Environment getEnvironmentTest() {
        return new Environment("Kitchen", 25d, 5d);
    }

    public static List<Environment> getEnvironmentListTest() {

        List<Environment> environmentList = new ArrayList<>();

        environmentList.add(new Environment("Room", 7d, 5d));

        environmentList.add(new Environment("Kitchen", 25d, 5d));

        environmentList.add(new Environment("Living", 5d, 5d));

        environmentList.add(new Environment("Bathroom", 20d, 5d));

        return environmentList;
    }

    public static List<EnvironmentDTO> getEnvironmentDTOList() {

        List<EnvironmentDTO> environmentList = new ArrayList<>();

        environmentList.add(new EnvironmentDTO("Room", 7d, 5d));

        environmentList.add(new EnvironmentDTO("Kitchen", 25d, 5d));

        environmentList.add(new EnvironmentDTO("Living", 5d, 5d));

        environmentList.add(new EnvironmentDTO("Bathroom", 20d, 5d));

        return environmentList;
    }

    public static List<EnvironmentSquareMetersDTO> getEnvironmentSquareMetersDTOTest() {
        return getEnvironmentDTOList().stream().map(x -> new EnvironmentSquareMetersDTO(x.getName(), (x.getLength() * x.getWidth()))).collect(Collectors.toList());
    }

    public static String makeObjectJsonString(Object object) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        return writer.writeValueAsString(object);
    }
}

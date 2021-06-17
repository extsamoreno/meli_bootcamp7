package com.example.challenge_2.Util;

import com.example.challenge_2.models.District;
import com.example.challenge_2.models.Environment;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.service.dto.DistrictDTO;
import com.example.challenge_2.service.dto.EnvironmentDTO;
import com.example.challenge_2.service.dto.PropertyDTO;

import java.util.ArrayList;
import java.util.List;

public class TestUtilsGenerator {

    public static Property getPropertyWithFourEnvironment() {
        List<Environment> environmentList = new ArrayList<>();

        environmentList.add(new Environment("Room", 7d, 5d));

        environmentList.add(new Environment("Kitchen", 30d, 5d));

        environmentList.add(new Environment("Living", 5d, 5d));

        environmentList.add(new Environment("Bathroom", 20d, 5d));

        return new Property(1, "Genaro's House", new District("Centro", 10d), environmentList);
    }

    public static PropertyDTO getPropertyDTOWithFourEnvironment() {
        List<EnvironmentDTO> environmentList = new ArrayList<>();

        environmentList.add(new EnvironmentDTO("Room", 7d, 5d));

        environmentList.add(new EnvironmentDTO("Kitchen", 30d, 5d));

        environmentList.add(new EnvironmentDTO("Living", 5d, 5d));

        environmentList.add(new EnvironmentDTO("Bathroom", 20d, 5d));

        return new PropertyDTO("Kevin's House", new DistrictDTO("Centro"), environmentList);
    }
}

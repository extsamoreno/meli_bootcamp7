package com.tuCasita.api.testUtil;

import com.tuCasita.api.dto.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TestUtil {
    public static PropertyDTO getPropertyDTOWith3Environments(){
        return new PropertyDTO(
                "House",
                new DistrictDTO(
                        "District1",
                        10.0
                ),
                new ArrayList<>(Arrays.asList(
                        new EnvironmentDTO(
                                "Environment1",
                                2.0,
                                2.0
                        ),
                        new EnvironmentDTO(
                                "Environment2",
                                2.0,
                                2.0
                        ),
                        new EnvironmentDTO(
                                "Environment3",
                                2.0,
                                2.0
                        )
                ))
        );
    }

    public static PropertyWithTotalSquareMetersDTO getPropertyWithTotalSquareMeters(){
        PropertyDTO propertyDTO = getPropertyDTOWith3Environments();
        return new PropertyWithTotalSquareMetersDTO(
                propertyDTO.getName(),
                propertyDTO.getDistrict(),
                propertyDTO.getEnvironments(),
                12
        );
    }

    public static PropertyWithTotalValueDTO getPropertyWithTotalValue() {
        PropertyDTO propertyDTO = getPropertyDTOWith3Environments();
        return new PropertyWithTotalValueDTO(
                propertyDTO.getName(),
                propertyDTO.getDistrict(),
                propertyDTO.getEnvironments(),
                120
        );
    }

    public static PropertyWithBiggestEnvironmentDTO getPropertyWithBiggestEnvironment() {
        PropertyDTO propertyDTO = getPropertyDTOWith3EnvironmentsOneBiggest();
        var biggestEnvironment = propertyDTO.getEnvironments().get(0);
        return new PropertyWithBiggestEnvironmentDTO(
                propertyDTO.getName(),
                propertyDTO.getDistrict(),
                propertyDTO.getEnvironments(),
                new EnvironmentWithTotalSquareMetersDTO(
                        biggestEnvironment.getName(),
                        biggestEnvironment.getWidth(),
                        biggestEnvironment.getLength(),
                        biggestEnvironment.getLength()* biggestEnvironment.getWidth()
                )
        );
    }

    public static ArrayList<EnvironmentWithTotalSquareMetersDTO> getEnvironmentsWithTotalSquareMeters(){
        ArrayList<EnvironmentWithTotalSquareMetersDTO> environments = new ArrayList<>();
        environments.add(new EnvironmentWithTotalSquareMetersDTO(
                "Environment1",
                2.0,
                2.0,
                4
        ));
        environments.add(new EnvironmentWithTotalSquareMetersDTO(
                "Environment2",
                2.0,
                2.0,
                4
        ));
        environments.add(new EnvironmentWithTotalSquareMetersDTO(
                "Environment3",
                2.0,
                2.0,
                4
        ));

        return environments;
    }

    public static PropertyWithTotalSquareMetersByEnvironmentDTO getPropertyWithTotalSquareMetersByEnvironment() {
        PropertyDTO propertyDTO = getPropertyDTOWith3Environments();
        return new PropertyWithTotalSquareMetersByEnvironmentDTO(
                propertyDTO.getName(),
                propertyDTO.getDistrict(),
                getEnvironmentsWithTotalSquareMeters()
        );
    }

    public static PropertyDTO getPropertyDTOWith3EnvironmentsOneBiggest() {
        return new PropertyDTO(
                "House",
                new DistrictDTO(
                        "District1",
                        10.0
                ),
                new ArrayList<>(Arrays.asList(
                        new EnvironmentDTO(
                                "Environment1",
                                5.0,
                                5.0
                        ),
                        new EnvironmentDTO(
                                "Environment2",
                                2.0,
                                2.0
                        ),
                        new EnvironmentDTO(
                                "Environment3",
                                2.0,
                                2.0
                        )
                ))
        );
    }

    public static HashSet<String> getDistrictNames(){
        HashSet<String> names = new HashSet<>();

        names.add("District1");
        names.add("District2");

        return names;
    }
}

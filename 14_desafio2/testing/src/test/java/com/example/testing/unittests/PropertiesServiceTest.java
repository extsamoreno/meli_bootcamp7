package com.example.testing.unittests;

import com.example.testing.dto.EnvironmentDTO;
import com.example.testing.exceptions.DistrictNotFoundException;
import com.example.testing.model.District;
import com.example.testing.model.Environment;
import com.example.testing.model.Property;
import com.example.testing.repositories.IPropertiesRepository;
import com.example.testing.services.IPropertiesService;
import com.example.testing.services.PropertiesService;
import com.example.testing.services.mapper.Mapper;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.internal.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertiesServiceTest {

    @Mock
    IPropertiesRepository propertiesRepository;

    @Mock
    Mapper mapper;

    @InjectMocks
    PropertiesService propertiesService;

    static Property property;

    static ArrayList<EnvironmentDTO> environmentDTOS = new ArrayList<>();

    static Environment environment;

    @BeforeAll
    public static void setUp(){
        property = new Property(1,
                "House1",
                new District("District1", 1000.0),
                new ArrayList<Environment>(Arrays.asList(
                        new Environment("Bathroom", 4.0, 4.0),
                        new Environment("Kitchen", 6.0, 6.0),
                        new Environment("Bedroom", 5.0, 5.0),
                        new Environment("LivingRoom", 8.0, 8.0))));
        environment = new Environment("LivingRoom", 8.0, 8.0);

        environmentDTOS.add(new EnvironmentDTO("Bathroom", 16.0));
        environmentDTOS.add(new EnvironmentDTO("Kitchen", 36.0));
        environmentDTOS.add(new EnvironmentDTO("Bedroom", 25.0));
        environmentDTOS.add(new EnvironmentDTO("LivingRoom", 64.0));
    }

    @Test
    public void getSquareMeters(){

        //arrange

        Mockito.when(propertiesRepository.getPropertyById(property.getId())).thenReturn(property);

        //act

        propertiesService.totalSquareMeters(property.getId());

        //assert

        verify(propertiesRepository, atLeastOnce()).getPropertyById(property.getId());
        assertEquals(141.0, propertiesService.totalSquareMeters(property.getId()));

    }

    @Test
    public void getBiggestEnvironment(){

        //arrange

        Mockito.when(propertiesRepository.getPropertyById(property.getId())).thenReturn(property);

        //act

        propertiesService.getBiggestEnvironment(property.getId());

        //assert

        verify(propertiesRepository, atLeastOnce()).getPropertyById(property.getId());
        assertEquals(environment, propertiesService.getBiggestEnvironment(property.getId()));
    }

    @Test
    public void getEnvironments(){

        //arrange

        when(propertiesRepository.getPropertyById(property.getId())).thenReturn(property);

        when(mapper.listToDTO(property.getEnvironments())).thenReturn(environmentDTOS);
        //act

        propertiesService.getEnvironments(property.getId());

        //assert

        verify(propertiesRepository, atLeastOnce()).getPropertyById(property.getId());
        assertEquals(environmentDTOS, propertiesService.getEnvironments(property.getId()));
    }

    @Test
    public void createDistrictNotFoundException() {
        // arrange

        property.getDistrict().setName("hohohohooho");


        // act
        DistrictNotFoundException exception = assertThrows(DistrictNotFoundException.class, () -> {
            propertiesService.createProperty(property);
        });

        String expectedException = "DistrictNotFoundException";
        String actualException = exception.getError().getName();
        assertTrue(actualException.contains(expectedException));
    }

    @Test
    public void create() {
        // arrange


        // act
        propertiesService.createProperty(property);

        // assert
        verify(propertiesRepository, atLeastOnce()).createProperty(property);
    }

}

package com.example.testing;

import com.example.testing.dto.EnvironmentDTO;
import com.example.testing.model.District;
import com.example.testing.model.Environment;
import com.example.testing.model.Property;
import com.example.testing.repositories.IPropertiesRepository;
import com.example.testing.services.IPropertiesService;
import com.example.testing.services.PropertiesService;
import com.example.testing.services.mapper.Mapper;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.internal.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertiesServiceTest {

    @Mock
    IPropertiesRepository propertiesRepository;

    @Mock
    Mapper mapper;

    @InjectMocks
    PropertiesService propertiesService;

    @Test
    public void getSquareMeters(){

        //arrange

        Property property = new Property(1,
                "House1",
                new District("District1", 1000.0),
                new ArrayList<Environment>(Arrays.asList(
                        new Environment("Bathroom", 4.0, 4.0),
                        new Environment("Kitchen", 6.0, 6.0),
                        new Environment("Bedroom", 5.0, 5.0),
                        new Environment("LivingRoom", 8.0, 8.0))));
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
        Environment environment = new Environment("LivingRoom", 8.0, 8.0);
        Property property = new Property(1,
                "House1",
                new District("District1", 1000.0),
                new ArrayList<Environment>(Arrays.asList(
                        new Environment("Bathroom", 4.0, 4.0),
                        new Environment("Kitchen", 6.0, 6.0),
                        new Environment("Bedroom", 5.0, 5.0),
                        new Environment("LivingRoom", 8.0, 8.0))));
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

        ArrayList<EnvironmentDTO> environments = new ArrayList<>();
        Property property = new Property(1,
                "House1",
                new District("District1", 1000.0),
                new ArrayList<Environment>(Arrays.asList(
                        new Environment("Bathroom", 4.0, 4.0),
                        new Environment("Kitchen", 6.0, 6.0),
                        new Environment("Bedroom", 5.0, 5.0),
                        new Environment("LivingRoom", 8.0, 8.0))));

        environments.add(new EnvironmentDTO("Bathroom", 16.0));
        environments.add(new EnvironmentDTO("Kitchen", 36.0));
        environments.add(new EnvironmentDTO("Bedroom", 25.0));
        environments.add(new EnvironmentDTO("LivingRoom", 64.0));

        when(propertiesRepository.getPropertyById(property.getId())).thenReturn(property);

        for (Environment e: property.getEnvironments()) {
            for(EnvironmentDTO eDTO : environments){
                when(mapper.toDTO(e)).thenReturn(eDTO);
            }
        }

        //act

        ArrayList<EnvironmentDTO> environmentsActual = propertiesService.getEnvironments(property.getId());

        //assert

        verify(propertiesRepository, atLeastOnce()).getPropertyById(property.getId());
        assertEquals(environments.get(3), environmentsActual.get(0));
    }

}

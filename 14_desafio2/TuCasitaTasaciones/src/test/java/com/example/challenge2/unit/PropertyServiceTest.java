package com.example.challenge2.unit;

import com.example.challenge2.dtos.EnvironmentDTO;
import com.example.challenge2.dtos.PropertyDTO;
import com.example.challenge2.mappers.Mapper;
import com.example.challenge2.repository.IPropertyRepository;
import com.example.challenge2.service.PropertyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @Mock
    IPropertyRepository propertyRepository;

    @Mock
    Mapper mapper;

    @InjectMocks
    PropertyService service;
    PropertyDTO house = new PropertyDTO("Prop1", "Ñuñoa", new ArrayList<>(){
        {
            add(new EnvironmentDTO("Environment1", 1.0, 2.0));
            add(new EnvironmentDTO("Environment2", 2.0, 3.0));
        }
    });

    @Test
    public void create() {
    }
    }
package com.example.Challenge2.Controllers;

import com.example.Challenge2.Services.IPropertyService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    IPropertyService iPropertyService;

    @InjectMocks
    PropertyController propertyController;


    public void getBiggestRoomTest(){


    }
}

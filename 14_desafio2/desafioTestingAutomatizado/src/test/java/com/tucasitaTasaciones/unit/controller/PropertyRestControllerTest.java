package com.tucasitaTasaciones.unit.controller;

import com.tucasitaTasaciones.controller.CalculateRestController;
import com.tucasitaTasaciones.controller.PropertyRestController;
import com.tucasitaTasaciones.dto.PropertyDTO;
import com.tucasitaTasaciones.service.ICalculateService;
import com.tucasitaTasaciones.service.IPropertyService;
import com.tucasitaTasaciones.unit.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyRestControllerTest {

    @Mock
    IPropertyService service;

    @InjectMocks
    PropertyRestController controller;

    @Test
    public void addNewPropertyTest() {
        PropertyDTO p = TestUtilGenerator.getPropertyDTO("King");
        ResponseEntity<?> found = controller.addNewProperty(p);
        Mockito.verify(service, Mockito.atLeastOnce()).addNewProperty(p);
        Assertions.assertEquals(200, found.getStatusCodeValue());
    }


    @Test
    public void getAllPropertiesTest() {
        ResponseEntity<List<PropertyDTO>> found = controller.getAllProperties();
        Assertions.assertEquals(200, found.getStatusCodeValue());
    }

}
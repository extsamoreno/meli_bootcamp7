package com.example.demo.repository;

import com.example.demo.DTO.PropertyDTO;
import com.example.demo.Utils.UtilTest;
import com.example.demo.entities.Property;
import com.example.demo.repositories.DistrictRepository;
import com.example.demo.repositories.PropertyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyRepositoryTest {

    PropertyRepository propertyRepository= new PropertyRepository();

    @Test
    public void addPropertyTest() throws Exception {

        Property property = UtilTest.getPropertyWithEnvironments();
        int beforeSize = propertyRepository.loadProperties().size();

        propertyRepository.addProperty(property);
        propertyRepository.saveProperty();

        assertEquals(beforeSize +1 , propertyRepository.loadProperties().size());
    }


   /* @Test
    public void getPropertyByIdTest() {
        Property property = UtilTest.getPropertyWithEnvironments();
        propertyRepository.addProperty(property);
        propertyRepository.saveProperty();

        Property aux = propertyRepository.getPropertyById(property.getId());

        Assertions.assertEquals(aux,property);
    }*/

}

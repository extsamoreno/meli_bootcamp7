package com.desafio2.demo.Repository;

import com.desafio2.demo.Exception.DistrictNotExist;
import com.desafio2.demo.Model.District;
import com.desafio2.demo.Repository.PropRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropRepositoryTest {

    @InjectMocks
    PropRepository propRepository;

    @Test
    void getDistrictByName() throws DistrictNotExist {
        //arrange
        District district = new District("Villa Prado", 400.0);
        //act
        District response = propRepository.getDistrictByName("Villa Prado");
        //assert
        assertEquals(district, response);
    }

    @Test
    void getDistrictNullName() {
        //assert
        assertThrows(DistrictNotExist.class, ()->  propRepository.getDistrictByName("Villa"));
    }



}
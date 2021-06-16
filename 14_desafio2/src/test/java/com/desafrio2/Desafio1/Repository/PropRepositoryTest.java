package com.desafrio2.Desafio1.Repository;

import com.desafrio2.Desafio1.Exception.DistrictNotExist;
import com.desafrio2.Desafio1.Model.District;
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
        District district = new District("Villa Prado", 300.0);
        //act
        District response = propRepository.getDistrictByName("Villa Prado");
        //assert
        assertEquals(district, response);
    }

    @Test
    void getDistricNullName() {
        //assert
        assertThrows(DistrictNotExist.class, ()->  propRepository.getDistrictByName("Villa"));
    }



}
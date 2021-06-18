package com.desafio2.demo.Repository;

import com.desafio2.demo.Exception.DistrictNotExistException;
import com.desafio2.demo.Model.District;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropRepositoryTest {

    @InjectMocks
    PropRepository propRepository;

    @Test
    void getDistrictByName() throws DistrictNotExistException {
        //arrange
        District district = new District("Villa Prado", 400.0);
        //act
        District response = propRepository.getDistrictByName("Villa Prado");
        //assert
        assertEquals(district, response);
    }

    @Test()
    void loadDataFileNotFound() {
        //assert
        assertThrows(FileNotFoundException.class, ()->  propRepository.loadData("badPath.json"));
    }

    @Test
    void getDistrictNullName() {
        //assert
        assertThrows(DistrictNotExistException.class, ()->  propRepository.getDistrictByName("Villa"));
    }



}
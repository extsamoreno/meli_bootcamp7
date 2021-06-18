package com.meli.desafio2.unit;

import com.meli.desafio2.model.District;
import com.meli.desafio2.repository.DistrictRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class DistrictRepositoryTest {
    DistrictRepositoryImpl districtRepository;

    @BeforeEach
    public void setUp(){ this.districtRepository = new DistrictRepositoryImpl(); }

    @Test
    public void findDistrictByID_Success(){
        //Arrange
        int district_id = 1;

        //Act
        District found = districtRepository.findDistrictByID(district_id);

        //Assert
        Assertions.assertEquals(district_id, found.getId());
    }

    @Test
    public void findDistrictByID_Exception(){
        //Arrange
        int district_id = 234234;

        //Act
        District expected = districtRepository.findDistrictByID(district_id);

        //Assert
        Assertions.assertNull(expected);
    }

}
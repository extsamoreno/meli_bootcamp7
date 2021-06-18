package com.meli.desafio2.unit.repository;

import com.meli.desafio2.unit.Utils;
import com.meli.desafio2.web.model.District;
import com.meli.desafio2.web.repository.DistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;


public class DistrictRepositoryTest {
    @Test
    public void getDistrictByNameTest(){
        //arrange
        String name = "Brook";
        District expected = new District(name,120);
        DistrictRepository obj = new DistrictRepository();
        //act
        District response = obj.getDistrictByName(name);
        //assert
        Assertions.assertEquals(expected,response);
    }

}

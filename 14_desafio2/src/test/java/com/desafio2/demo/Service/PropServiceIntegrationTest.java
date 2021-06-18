package com.desafio2.demo.Service;
import com.desafio2.demo.Exception.DistrictNotExistException;
import com.desafio2.demo.Model.DTO.PropDTOTPrice;
import com.desafio2.demo.Model.DTO.PropRequest;
import com.desafio2.demo.Util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class PropServiceIntegrationTest {

    @Autowired
    private PropService propService;

    @Test
    void priceProp() throws DistrictNotExistException {
        //arrange
        PropRequest request = Util.getPropRequest();
        PropDTOTPrice expected = new PropDTOTPrice("House1", 16000.0);
        //act
        PropDTOTPrice prop = propService.priceProp(request);
        //assert
        assertEquals(expected, prop);
    }

}
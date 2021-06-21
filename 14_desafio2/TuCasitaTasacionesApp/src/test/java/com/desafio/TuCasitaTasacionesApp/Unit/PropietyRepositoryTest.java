package com.desafio.TuCasitaTasacionesApp.Unit;

import com.desafio.TuCasitaTasacionesApp.model.dao.models.Propiety;
import com.desafio.TuCasitaTasacionesApp.model.dao.repository.PropietyRepository;
import com.desafio.TuCasitaTasacionesApp.model.service.helpers.CreateProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PropietyRepositoryTest {

    @Test
    void createPropietyHappyPath(){
        //arrange
        String name = "name";
        String neighborhood = "Constitucion";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyRepository propietyRepository = new PropietyRepository();

        //act
        boolean receive = propietyRepository.create(propiety);

        //assert
        assertTrue(receive);
    }


    @Test
    void createPropiety_propietyFound_false(){
        //arrange
        String name = "name";
        String neighborhood = "Constitucion";
        Propiety propiety = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyRepository propietyRepository = new PropietyRepository();

        //act
        propietyRepository.create(propiety);
        boolean receive = propietyRepository.create(propiety);

        //assert
        assertFalse(receive);
    }

    @Test
    void getPropietyHappyPath(){
        //arrange
        String name = "name";
        String neighborhood = "Constitucion";
        Propiety expected = CreateProperties.create1HouseWith2Rooms1x1(name, neighborhood);
        PropietyRepository propietyRepository = new PropietyRepository();
        propietyRepository.create(expected);

        //act
        Propiety receive = propietyRepository.get(name);

        //assert
        assertEquals(expected, receive);
    }

    @Test
    void getPropiety_propietyNotFound_null(){
        //arrange
        String name = "name";
        String neighborhood = "Constitucion";
        PropietyRepository propietyRepository = new PropietyRepository();

        //act
        Propiety propiety = propietyRepository.get("names");

        //assert
        assertNull(propiety);
    }

}
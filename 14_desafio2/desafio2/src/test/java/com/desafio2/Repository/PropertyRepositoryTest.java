package com.desafio2.Repository;

import com.desafio2.Exception.PropertyNotFoundException;
import com.desafio2.Model.Property;
import com.desafio2.Utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyRepositoryTest {

    IPropertyRepository iPropertyRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtils.emptyFile("properties.json");
        this.iPropertyRepository = new PropertyRepository();
    }

    @Test
    public void saveNoExistentPropertyTest() {
        //arrange
        Property property = TestUtils.createProperty("Avenue12");

        //act
        iPropertyRepository.save(property);

        //arrange
        Assertions.assertTrue(iPropertyRepository.exists(property));
        Assertions.assertEquals("Avenue12", property.getProp_name());
        Assertions.assertEquals(iPropertyRepository.findByName(property.getProp_name()), property);
    }

    @Test
    public void modifyExistentPropertyTest() {
        //arrange
        Property property1 = TestUtils.createProperty("Avenue1");
        Property property2 = TestUtils.createProperty("Avenue1");
        property2.setDistrict_name("South");
        iPropertyRepository.save(property1);

        //act
        iPropertyRepository.save(property2);

        //assert
        Assertions.assertTrue(iPropertyRepository.exists(property2));
        Assertions.assertFalse(iPropertyRepository.exists(property1));
        Assertions.assertEquals(iPropertyRepository.findByName(property2.getProp_name()), property2);
    }

    @Test
    public void findExistentPropertyTest() {
        //arrange
        Property property = TestUtils.createProperty("Avenue1");
        iPropertyRepository.save(property);

        //act
        Property found = iPropertyRepository.findByName(property.getProp_name());

        //assert
        Assertions.assertEquals(property, found);
    }

    @Test
    public void findNonExistentPropertyTest() {
        //arrange
        Property found = TestUtils.createProperty("Avenue1");

        //assert
        Assertions.assertThrows(PropertyNotFoundException.class, () -> iPropertyRepository.findByName(found.getProp_name()));
    }

    @Test
    public void deleteExistentPropertyTest() {
        // arrange
        Property property = TestUtils.createProperty("Avenue1");
        iPropertyRepository.save(property);

        // act
        iPropertyRepository.delete(property.getProp_name());

        // assert
        Assertions.assertFalse(iPropertyRepository.exists(property));
        Assertions.assertThrows(PropertyNotFoundException.class,() -> iPropertyRepository.findByName(property.getProp_name()));
    }

    @Test
    public void deleteNonExistentProperty() {
        // arrange
        Property property = TestUtils.createProperty("Avenue1");

        // act
        iPropertyRepository.delete(property.getProp_name());

        // assert
        Assertions.assertFalse(iPropertyRepository.exists(property));
        Assertions.assertThrows(PropertyNotFoundException.class,() -> iPropertyRepository.findByName(property.getProp_name()));
    }

}

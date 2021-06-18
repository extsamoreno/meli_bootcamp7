package com.example.tucasita.unit.repository;

import com.example.tucasita.exception.DistrictNotFoundException;
import com.example.tucasita.exception.ExistentDistrictException;
import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.repository.DistrictDAOImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistrictDAOTests {

    DistrictDAO districtDAO;

    @BeforeEach
    public void init() {
        districtDAO = new DistrictDAOImple();
    }

    @Test
    public void testCreateNewDistrict() {
        //ARRANGE
        DistrictDTO newDistrict = new DistrictDTO("Almagro", 300.00);

        //ACT
        districtDAO.create(newDistrict);
        DistrictDTO createdDistrict = districtDAO.findByName(newDistrict.getDistrictName());

        //ASSERT
        Assertions.assertEquals(newDistrict, createdDistrict);
    }

    @Test
    public void testCreateExistentDistrict() {
        //ARRANGE
        DistrictDTO existentDistrict = new DistrictDTO("Belgrano", 250.00);

        //ACT

        //ASSERT
        Assertions.assertThrows(ExistentDistrictException.class, () -> districtDAO.create(existentDistrict));
    }

    @Test
    public void testFindByNameExistentDistrict() {
        //ARRANGE
        String districtName = "Belgrano";
        DistrictDTO expectedDistrict = new DistrictDTO("Belgrano", 250.00);

        //ACT
        DistrictDTO receivedDistrict = districtDAO.findByName(districtName);

        //ASSERT
        Assertions.assertEquals(expectedDistrict, receivedDistrict);
    }

    @Test
    public void testFindByNameInexistentDistrict() {
        //ARRANGE
        String inexistentDistrictName = "Villa Urquiza";

        //ACT

        //ASSERT
        Assertions.assertThrows(DistrictNotFoundException.class, () -> districtDAO.findByName(inexistentDistrictName));
    }
}

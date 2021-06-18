package com.example.tucasita.unit.repository;

import com.example.tucasita.exception.DistrictNotFoundException;
import com.example.tucasita.exception.ExistentDistrictException;
import com.example.tucasita.model.District;
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
        District newDistrict = new District("Almagro", 300.00);

        //ACT
        districtDAO.create(newDistrict);
        District createdDistrict = districtDAO.findByName(newDistrict.getDistrictName());

        //ASSERT
        Assertions.assertEquals(newDistrict, createdDistrict);
    }

    @Test
    public void testCreateExistentDistrict() {
        //ARRANGE
        District existentDistrict = new District("Belgrano", 250.00);

        //ACT

        //ASSERT
        Assertions.assertThrows(ExistentDistrictException.class, () -> districtDAO.create(existentDistrict));
    }

    @Test
    public void testFindByNameExistentDistrict() {
        //ARRANGE
        String districtName = "Belgrano";
        District expectedDistrict = new District("Belgrano", 250.00);

        //ACT
        District receivedDistrict = districtDAO.findByName(districtName);

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

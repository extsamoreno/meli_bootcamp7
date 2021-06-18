package com.example.challenge2.unit;

import com.example.challenge2.exceptions.DistrictNotFoundException;
import com.example.challenge2.models.District;
import com.example.challenge2.repositories.DistrictDAO;
import com.example.challenge2.repositories.IDistrictDAO;
import com.example.challenge2.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistrictDAOTest {
    IDistrictDAO districtDAO;

    @BeforeEach
    @AfterEach
    private void setUp() { this.districtDAO = new DistrictDAO();
        TestUtilGenerator.emptyFiles();}

    @Test
    public void saveDistrictOk() {
        // arrange
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(800.00);
        // act
        District received = districtDAO.save(district);

        // assert
        Assertions.assertEquals(received, district);
    }


    @Test
    public void findExistentPropertyById() {
        //Arrange
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(400.00);
        TestUtilGenerator.appendNewDistrict(district);
        //Act
        District found = districtDAO.findByName(district.getName());

        //Assert
        Assertions.assertEquals(found,district);
    }

    @Test
    public void existExistentPropertyById() {
        //Arrange
        District district = new District();
        district.setName("Carrasco");
        district.setPrice(400.00);
        TestUtilGenerator.appendNewDistrict(district);

        //Act
        Boolean found = districtDAO.exist(district.getName());

        //Assert
        Assertions.assertEquals(found,true);
    }

    @Test
    public void existNonExistentPropertyById() {
        //Arrange
        String name = "Error";

        //Assert
        Assertions.assertThrows(DistrictNotFoundException.class,() -> districtDAO.exist(name));
    }

    @Test
    public void findNonExistentPropertyById() {
        //Arrange
        String name = "Error";

        //Assert
        Assertions.assertThrows(DistrictNotFoundException.class,() -> districtDAO.findByName(name));
    }
}

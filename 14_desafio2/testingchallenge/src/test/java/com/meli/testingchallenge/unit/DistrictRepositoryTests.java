package com.meli.testingchallenge.unit;

import com.meli.testingchallenge.exceptions.ExistentDistrictNameException;
import com.meli.testingchallenge.models.District;
import com.meli.testingchallenge.repositories.DistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DistrictRepositoryTests {

    @Test
    public void should_add_new_district_successfully() throws ExistentDistrictNameException {

        // Arrange
        District district = new District("test1", 22.22);
        DistrictRepository districtRepository = new DistrictRepository();
        districtRepository.setDistricts(new ArrayList<>());

        // Act
        districtRepository.addDistrict(district);

        // Assert
        District received = districtRepository.getDistricts().get(0);
        Assertions.assertEquals(district, received);

    }

    @Test
    public void should_throw_exception_adding_exiting_district_() throws ExistentDistrictNameException {
        // Arrange
        District district = new District("test1", 22.22);
        DistrictRepository districtRepository = new DistrictRepository();
        districtRepository.setDistricts(new ArrayList<>());
        districtRepository.addDistrict(district);

        // Act // Assert
        assertThrows(ExistentDistrictNameException.class, () -> districtRepository.addDistrict(district));

    }

    @Test
    public void should_return_the_right_district_when_it_find_one() throws ExistentDistrictNameException {
        // Arrange
        String districtName =  "test1";
        District district = new District(districtName, 22.22);
        DistrictRepository districtRepository = new DistrictRepository();
        List<District> districts =  new ArrayList<>();
        districts.add(district);
        districtRepository.setDistricts(districts);

        // Act
        District received = districtRepository.findDistrictByName(districtName);

        // Assert
        Assertions.assertEquals(district, received);
    }

    @Test
    public void should_return_null_when_does_not_find_any() throws ExistentDistrictNameException {
        // Arrange
        String districtName =  "test1";
        DistrictRepository districtRepository = new DistrictRepository();

        // Act
        District received = districtRepository.findDistrictByName(districtName);

        // Assert
        Assertions.assertEquals(null, received);
    }
}

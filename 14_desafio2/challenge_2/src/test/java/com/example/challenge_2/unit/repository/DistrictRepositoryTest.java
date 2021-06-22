package com.example.challenge_2.unit.repository;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.District;
import com.example.challenge_2.repository.DistrictRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DistrictRepositoryTest {

    @InjectMocks
    DistrictRepository districtRepository;

    @Test
    public void getByNameTest() throws DistrictNotFoundException {

        //Arrange
        String name = "Centro";
        District district = TestUtilsGenerator.getDistrictTest();

        //Act
        District result = districtRepository.getByName(name);

        //Assert
        assertEquals(district, result);
    }

    @Test
    public void getByNameDistrictNotFoundTest() {

        //Arrange
        String name = "__";

        //Act

        //Assert
        assertThrows(DistrictNotFoundException.class, () -> districtRepository.getByName(name));
    }
}

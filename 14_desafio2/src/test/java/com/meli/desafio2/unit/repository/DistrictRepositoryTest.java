package com.meli.desafio2.unit.repository;

import com.meli.desafio2.exception.DistrictIdNotFoundException;
import com.meli.desafio2.model.District;
import com.meli.desafio2.repository.DistrictRepository;
import com.meli.desafio2.repository.IDistrictRepository;
import com.meli.desafio2.util.TestUtilsGen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DistrictRepositoryTest {

    IDistrictRepository districtRepository;

    @BeforeEach
    private void setUp(){
        this.districtRepository = new DistrictRepository();
    }

    // District exists
    @Test
    public void getDistrictByIdExists() throws DistrictIdNotFoundException {

        // Arrange
        int distId = 0;
        District dist = TestUtilsGen.getDistWithId(distId);

        // Act
        District responseDist = districtRepository.getDistrictbyId(distId);

        // Assert
        Assertions.assertEquals(dist, responseDist);
    }

    // District not exists
    @Test
    public void getDistrictByIdNonExists() {

        // Arrange
        int distId = 100;
        District dist = TestUtilsGen.getDistWithId(distId);

        // Act & Assert
        Assertions.assertThrows(DistrictIdNotFoundException.class,() -> districtRepository.getDistrictbyId(dist.getId()));
    }
}

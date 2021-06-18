package meli.bootcamp.tucasita.unit.repository;

import meli.bootcamp.tucasita.model.District;
import meli.bootcamp.tucasita.repository.DistrictRepository;
import meli.bootcamp.tucasita.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistrictRepositoryTest {

    DistrictRepository districtRepository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyDistrictFile();
        this.districtRepository = new DistrictRepository();
    }

    @Test
    public void SaveDistrict()   {
        // arrange
        District expected = new District("District test",500);

        // act
        District found = districtRepository.save(expected);

        // assert
        Assertions.assertEquals(expected, found);
    }

    @Test
    public void ISholdNotChangeDistrictTest()   {
        // arrange
        District expected = new District("District test",500);
        District notChange = new District("District test",1500);
        // act
        districtRepository.save(expected);
        District found = districtRepository.save(notChange);

        // assert
        Assertions.assertEquals(expected, found);
    }
}

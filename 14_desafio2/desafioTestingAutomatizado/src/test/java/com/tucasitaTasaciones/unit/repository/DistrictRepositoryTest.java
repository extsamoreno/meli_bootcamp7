package com.tucasitaTasaciones.unit.repository;

import com.tucasitaTasaciones.exceptions.DistrictNotFoundException;
import com.tucasitaTasaciones.model.District;
import com.tucasitaTasaciones.repository.DistrictRepository;
import com.tucasitaTasaciones.repository.IDistrictRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DistrictRepositoryTest {
    IDistrictRepository repository;

    @BeforeEach
    @AfterEach
    private void setUp() {
        this.repository = new DistrictRepository();
    }

    @Test
    public void findExistentDistrictByName() {
        String districtName = "Snohomish";

        District found = repository.findDistrictByName(districtName);

        Assertions.assertEquals(found.getDistrict_name(), districtName);
    }

    @Test
    public void findNonExistentDistrictByName() {
        String districtName = "Capital";

        Assertions.assertThrows(DistrictNotFoundException.class,
                () -> repository.findDistrictByName(districtName));
    }


}

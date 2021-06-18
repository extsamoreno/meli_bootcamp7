package com.tucasitaTasaciones.unit.repository;

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
    public void findExistentDistrictByNameTest() {
        String districtName = "Snohomish";

        District found = repository.findDistrictByName(districtName);

        Assertions.assertNotNull(found);
    }




}

package com.tucasita.tasaciones.repository;

import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NeighborhoodRepositoryTest {

    NeighborhoodRepository neighborhoodRepository;

    @BeforeEach @AfterEach
    private void init() throws IOException {
        TestUtilGenerator.filledNeighborhoodFile();
        this.neighborhoodRepository = new NeighborhoodRepositoryImpl();
    }

    @Test
    public void findByNameTest() {
        Neighborhood n = neighborhoodRepository.getByName("La Plata");
        Assertions.assertNotNull(n);
    }
}

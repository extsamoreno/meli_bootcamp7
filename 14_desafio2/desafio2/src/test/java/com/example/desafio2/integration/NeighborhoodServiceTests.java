package com.example.desafio2.integration;

import com.example.desafio2.exceptions.NeighborhoodAlreadyExistException;
import com.example.desafio2.models.NeighborhoodDTO;
import com.example.desafio2.services.INeighborhoodService;
import com.example.desafio2.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class NeighborhoodServiceTests {

    @Autowired
    INeighborhoodService iNeighborhoodService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyFiles();
    }

    @Test
    public void createNeighborhoodOk() throws NeighborhoodAlreadyExistException {
        // arrange
        NeighborhoodDTO neighborhood = TestUtilsGenerator.getNeighborhoodPriceTen("Avellaneda Uno");
        NeighborhoodDTO expected = TestUtilsGenerator.getNeighborhoodWithId("Avellaneda Uno", 2);

        // act
        NeighborhoodDTO received = iNeighborhoodService.createNeighborhood(neighborhood);

        // assert
        assertEquals(expected, received);
    }
}

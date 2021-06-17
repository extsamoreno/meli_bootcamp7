package com.meli.testingchallenge.unit;

import com.meli.testingchallenge.models.Environment;
import com.meli.testingchallenge.services.EstateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EstateServiceTests {

    @Test
    public void should_calculate_surface_of_environment(){

        // Arrange
        double width1 = 2.0;
        double length1 = 5.0;
        Environment environment1 = new Environment("env1", width1, length1 );
        EstateService service = new EstateService();
        double expected = width1 * length1;

        // Act
        double received = service.calculateEnvironmentSurface(environment1);

        // Assert
        Assertions.assertEquals(expected, received);
    }
}

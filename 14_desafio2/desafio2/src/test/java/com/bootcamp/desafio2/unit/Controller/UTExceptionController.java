package com.bootcamp.desafio2.unit.Controller;

import com.bootcamp.desafio2.UtilsGenerator;
import com.bootcamp.desafio2.controller.ExceptionController;
import com.bootcamp.desafio2.controller.HouseController;
import com.bootcamp.desafio2.dto.response.ErrorDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ExtendWith(MockitoExtension.class)
public class UTExceptionController {

    @InjectMocks
    ExceptionController exceptionController;

    @Test
    public void handleHouseNotFoundExceptionSuccessfullyBody() {
        // Arrange
        String prop_name = "Casa000";
        HouseNotFoundException e = new HouseNotFoundException(prop_name);
        ErrorDTO error = new ErrorDTO();
        error.setName("HouseNotFoundException");
        error.setMessage("The Property with the name: " +prop_name+ " is not found in the DataBase.");

        // Act
        ResponseEntity<?> response = exceptionController.handleHouseNotFoundException( e );

        // Assert
        Assertions.assertEquals(error, response.getBody());
    }

    @Test
    public void handleHouseNotFoundExceptionSuccessfullyStatus() {
        // Arrange
        String prop_name = "Casa000";
        HouseNotFoundException e = new HouseNotFoundException(prop_name);
        ErrorDTO error = new ErrorDTO();
        error.setName("HouseNotFoundException");
        error.setMessage("The Property with the name: " +prop_name+ " is not found in the DataBase.");

        // Act
        ResponseEntity<?> response = exceptionController.handleHouseNotFoundException( e );

        // Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void handleDistrictNotFoundExceptionSuccessfullyBody() {
        // Arrange
        String district_name = "Molinos";
        DistrictNotFoundException e = new DistrictNotFoundException(district_name);
        ErrorDTO error = new ErrorDTO();
        error.setName("DistrictNotFoundException");
        error.setMessage("The District with the name: " +district_name+ " is not found in the DataBase.");

        // Act
        ResponseEntity<?> response = exceptionController.handleDistrictNotFoundException( e );

        // Assert
        Assertions.assertEquals(error, response.getBody());
    }

    @Test
    public void handleDistrictNotFoundExceptionSuccessfullyStatus() {
        // Arrange
        String district_name = "Molinos";
        DistrictNotFoundException e = new DistrictNotFoundException(district_name);
        ErrorDTO error = new ErrorDTO();
        error.setName("DistrictNotFoundException");
        error.setMessage("The District with the name: " +district_name+ " is not found in the DataBase.");

        // Act
        ResponseEntity<?> response = exceptionController.handleDistrictNotFoundException( e );

        // Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void handleHouseAlreadyExistsExceptionSuccessfullyBody() {
        // Arrange
        String prop_name = "Casa101";
        HouseAlreadyExistsException e = new HouseAlreadyExistsException(prop_name);
        ErrorDTO error = new ErrorDTO();
        error.setName("HouseAlreadyExistsException");
        error.setMessage("The Property with name: " +prop_name+ " already exists in the DataBase.");

        // Act
        ResponseEntity<?> response = exceptionController.handleHouseAlreadyExistsException( e );

        // Assert
        Assertions.assertEquals(error, response.getBody());
    }

    @Test
    public void handleHouseAlreadyExistsExceptionSuccessfullyStatus() {
        // Arrange
        String prop_name = "Casa101";
        HouseAlreadyExistsException e = new HouseAlreadyExistsException(prop_name);
        ErrorDTO error = new ErrorDTO();
        error.setName("HouseAlreadyExistsException");
        error.setMessage("The Property with name: " +prop_name+ " already exists in the DataBase.");

        // Act
        ResponseEntity<?> response = exceptionController.handleHouseAlreadyExistsException( e );

        // Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}

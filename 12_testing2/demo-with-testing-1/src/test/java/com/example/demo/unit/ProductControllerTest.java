package com.example.demo.unit;

import com.example.demo.project.controllers.ProductController;
import com.example.demo.project.dtos.ProductDTO;
import com.example.demo.project.exceptions.ProductIdNotFoundException;
import com.example.demo.project.services.ProductService;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;


    @Test
    public void getByIdWithIdCorrect()  throws ProductIdNotFoundException{
        //Arrange
        ProductDTO bodyExpected = new ProductDTO("ejemplo", 10);
        Integer value = 1;
        when(productService.getProductById(value)).thenReturn(bodyExpected);
        HttpStatus statusExpected = HttpStatus.BAD_REQUEST;

        //Act
        ResponseEntity<ProductDTO> response = productController.getById(value);
        ProductDTO bodyReceived = response.getBody();
        HttpStatus statusReceived = response.getStatusCode();


        //Assert
        assertEquals(bodyExpected, bodyReceived);
        assertEquals(statusExpected, statusReceived);

    }


}

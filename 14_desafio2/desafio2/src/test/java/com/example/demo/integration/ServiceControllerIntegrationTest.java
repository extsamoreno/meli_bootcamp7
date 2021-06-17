/*package com.example.demo.integration;


import com.example.demo.project.dtos.ProductDTO;
import com.example.demo.project.exceptions.ProductIdNotFoundException;
import com.example.demo.project.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceControllerIntegrationTest {

    @Autowired
    IProductService iProductService;

    @Test
    public void getProductByIdHappyPath() throws ProductIdNotFoundException {
        //Arrange
        ProductDTO expected = new ProductDTO("mouse", 10);

        //act
        ProductDTO received = iProductService.getProductById(1);

        assertEquals(expected,received);
    }
}*/

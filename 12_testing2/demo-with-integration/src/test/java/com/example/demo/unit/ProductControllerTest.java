package com.example.demo.unit;

import com.example.demo.project.controllers.ProductController;
import com.example.demo.project.dtos.ProductDTO;
import com.example.demo.project.services.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    IProductService iProductService;

    @InjectMocks
    ProductController productController;

    @Test
    public void createProductHappyPath(){
        //arrange
        ProductDTO product = new ProductDTO("mouse",10);
        Mockito.when(iProductService.createProduct(product)).thenReturn(true);

        //act
        ResponseEntity<Boolean> received = productController.createProduct(product);

        //assert
        Mockito.verify(iProductService,Mockito.atLeastOnce()).createProduct(product);
        Assertions.assertTrue(received.getBody());

    }
}

/*package com.example.demo.unit;

import com.example.demo.project.dtos.ProductDTO;
import com.example.demo.project.exceptions.ProductIdNotFoundException;
import com.example.demo.project.mappers.ProductMapper;
import com.example.demo.project.models.Product;
import com.example.demo.project.repositories.IProductRepository;
import com.example.demo.project.services.ProductService;
import com.fasterxml.jackson.databind.util.Annotations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    IProductRepository iProductRepository;

   // @Mock
   // ProductMapper productMapper;

    @InjectMocks
    ProductService productService;

    @Test
    public void getProductByIdHappyPath() throws ProductIdNotFoundException {
        //arrange
        int id = 1;
        Product product = new Product(1,"mouse", "asd123", 10);
        ProductDTO expected = new ProductDTO("mouse", 10);
        when(iProductRepository.getById(id)).thenReturn(product);
        //when(productMapper.toDTO(product)).thenReturn(expected);

        //act
        ProductDTO received = productService.getProductById(id);


        //assert
        verify(iProductRepository,Mockito.atLeast(1)).getById(id);
       // verify(productMapper, Mockito.atLeastOnce()).toDTO(product);

        assertEquals(expected, received);

    }

    @Test
    public  void getProductByIdThrowProductIdNotFoundException() throws ProductIdNotFoundException {
        //arrange
        int id = 1;
        when(iProductRepository.getById(id)).thenReturn(null);

        //assert
        assertThrows(ProductIdNotFoundException.class, () -> productService.getProductById(id));

    }


}*/

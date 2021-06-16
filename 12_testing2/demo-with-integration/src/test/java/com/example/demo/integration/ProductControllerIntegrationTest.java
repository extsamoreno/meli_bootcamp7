package com.example.demo.integration;

import com.example.demo.project.models.Product;
import com.example.demo.project.repositories.IProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IProductRepository iProductRepository;

    @Test
    public void getByIdHappyPath() throws Exception {

        int idProduct = 1;
        Product product = new Product(1,"mouse","asd123",10);
        Mockito.when(iProductRepository.getById(idProduct)).thenReturn(product);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/{id}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("{\"name\":\"mouse\",\"stock\":10}")))
                .andReturn();


    }

}

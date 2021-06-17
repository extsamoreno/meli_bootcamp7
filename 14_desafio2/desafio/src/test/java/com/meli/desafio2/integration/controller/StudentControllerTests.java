package com.meli.desafio2.integration.controller;

import com.meli.desafio2.unit.repository.IPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;
}

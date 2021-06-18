package com.meli.tucasita.integration;

import com.fasterxml.jackson.databind.*;
import com.meli.tucasita.dto.*;
import com.meli.tucasita.repository.PropertyRepositoryImpl;
import com.meli.tucasita.utils.Utils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PropertyRepositoryImpl propertyRepository;

  @BeforeAll
  public static void init(){
    System.out.println("Unit tests initializing...");
  }

  // ------------------------------------------------------------------------
  // ---------------------------  GET: HAPPY PATH ---------------------------
  // ------------------------------------------------------------------------

  @Test
  public void testCalculateAreaHappyPath() throws Exception {

    PropertyDto testProperty = Utils.getPropertyDto();
    int id = testProperty.getId(); // id = 18
    when(propertyRepository.findPropertyById(id)).thenReturn(testProperty);

    this.mockMvc.perform(MockMvcRequestBuilders.get("/calculateArea/{id}", id))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(testProperty.getName()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.area").value(21));
  }

//  @Test
//  public void testCalculatePriceHappyPath() throws Exception {
//
//    PropertyDto testProperty = Utils.getPropertyDto();
//    int id = testProperty.getId(); // id = 18
//    when(propertyRepository.findPropertyById(id)).thenReturn(testProperty);
//
//    this.mockMvc.perform(MockMvcRequestBuilders.get("/calculatePrice/{id}", id))
//            .andDo(print()).andExpect(status().isOk())
//            .andExpect(content().contentType("application/json"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Testing Property"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(67200.0));
//  }

//  @Test
//  public void testBiggestEnvironmentHappyPath() throws Exception {
//    this.mockMvc.perform(MockMvcRequestBuilders.get("/calculateArea/{id}", 1))
//            .andDo(print()).andExpect(status().isOk())
//            .andExpect(content().contentType("application/json"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Juramento 5623"));
//  }
//
//  @Test
//  public void testEnvironmentsHappyPath() throws Exception {
//    this.mockMvc.perform(MockMvcRequestBuilders.get("/calculateArea/{id}", 1))
//            .andDo(print()).andExpect(status().isOk())
//            .andExpect(content().contentType("application/json"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Juramento 5623"));
//  }



  }



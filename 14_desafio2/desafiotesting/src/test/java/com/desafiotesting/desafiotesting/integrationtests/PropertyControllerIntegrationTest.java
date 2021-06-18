package com.desafiotesting.desafiotesting.integrationtests;
import com.desafiotesting.desafiotesting.models.District;
import com.desafiotesting.desafiotesting.models.Property;
import com.desafiotesting.desafiotesting.repositories.IDistrictRepository;
import com.desafiotesting.desafiotesting.repositories.IPropertyRepository;
import com.desafiotesting.desafiotesting.services.dtos.PropertyDTO;
import com.desafiotesting.desafiotesting.utils.TestUtilGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ModelMapper mapper;

    @MockBean
    IPropertyRepository propertyRepository;

    @MockBean
    IDistrictRepository DistrictRepository;

    @Test
    public void registerPropertyHappyPathTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("District1");
        Property property = TestUtilGenerator.getProperty("District1");
        District district = TestUtilGenerator.getDistrict("District1");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(propertyDTO);

        Mockito.when(DistrictRepository.findByName(propertyDTO.getDistrictName())).thenReturn(district);
        Mockito.when(mapper.map(propertyDTO, Property.class)).thenReturn(property);

        MvcResult response =
                this.mockMvc.perform(MockMvcRequestBuilders.post("/property/registerproperty")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andDo(print()).andExpect(status().isOk())
                        .andReturn();

        Mockito.verify(DistrictRepository,Mockito.atLeast(1)).findByName(propertyDTO.getDistrictName());
        Mockito.verify(propertyRepository,Mockito.atLeast(1)).save(property);
        Assertions.assertEquals(200,response.getResponse().getStatus());
    }



}

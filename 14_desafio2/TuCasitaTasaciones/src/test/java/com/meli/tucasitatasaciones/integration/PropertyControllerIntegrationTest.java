package com.meli.tucasitatasaciones.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.tucasitatasaciones.dto.PropertyDTO;
import com.meli.tucasitatasaciones.model.District;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.district.IDistrictRepository;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import com.meli.tucasitatasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @MockBean
    IDistrictRepository iDistrictRepository;

    @Mock
    ModelMapper mapper;

    @Test
    public void registerNewPropertyHappyPath() throws Exception {
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("Alto Alberdi");
        Property property = TestUtilGenerator.getProperty();
        String payloadJson = TestUtilGenerator.toJson(propertyDTO);
        Mockito.when(mapper.map(propertyDTO,Property.class)).thenReturn(property);
        Mockito.when(iDistrictRepository.findDistrictByName("Alto Alberdi")).thenReturn(new District("Alto Alberdi",150.0));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/newProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

        Mockito.verify(iDistrictRepository,Mockito.atLeastOnce()).findDistrictByName("Alto Alberdi");
    }

    @Test
    public void registerNewPropertyNullPayload() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/newProperty"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void registerNewPropertyEmptyProperty() throws Exception {
        String payloadJson = TestUtilGenerator.toJson(new PropertyDTO());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/newProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    //TODO: Agregar test cuando el barrio no existe y tira una excepcion

    //TODO: revisar este test
    @Test
    public void getAllProperties() throws Exception {
        List<PropertyDTO> propertiesDTO = TestUtilGenerator.getPropertiesDTO();
        List<Property> properties = TestUtilGenerator.getProperties();
        Property property = TestUtilGenerator.getProperty();
        PropertyDTO propertyDTO = TestUtilGenerator.getPropertyDTO("Alto Alberdi");

        Mockito.when(iPropertyRepository.getAllProperties()).thenReturn(properties);
        Mockito.when(mapper.map(property,PropertyDTO.class)).thenReturn(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/getAllProperties"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSquareMeters[0].name").value(environmentDTOS.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSquareMeters[0].squareMeters").value(environmentDTOS.get(0).getSquareMeters()));;

//        Mockito.verify(mapper,Mockito.times(3)).map(TestUtilGenerator.getProperty(),PropertyDTO.class);
//        List<PropertyDTO> responseList = TestUtilGenerator.fromJsonToList(response.getResponse().getContentAsString(), PropertyDTO.class);
//        Assertions.assertEquals(propertyDTO,responseList.get(0));
    }
}

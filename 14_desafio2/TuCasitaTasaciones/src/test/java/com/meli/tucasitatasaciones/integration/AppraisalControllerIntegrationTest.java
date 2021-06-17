package com.meli.tucasitatasaciones.integration;

import com.meli.tucasitatasaciones.dto.EnvironmentDTO;
import com.meli.tucasitatasaciones.exception.PropertyNotFoundException;
import com.meli.tucasitatasaciones.model.Property;
import com.meli.tucasitatasaciones.repository.property.IPropertyRepository;
import com.meli.tucasitatasaciones.util.TestUtilGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppraisalControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    @MockBean
    ModelMapper mapper;

    @Test
    public void getTotalSquareMetersWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        property.setId(1);
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getTotalSquareMeters/{propertyId}", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalSquareMeters").value(40.0));

    }

    @Test
    public void getTotalSquareMetersWithNonExistingProperty() throws Exception {
        Mockito.when(iPropertyRepository.findPropertyById(1)).thenThrow(new PropertyNotFoundException(1));
        String expectedDescription = "El id 1 no pertenece a una propiedad registrada";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getTotalSquareMeters/{propertyId}", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }

    @Test
    public void getPropertyValueWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        property.setId(1);
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getPropertyValue/{propertyId}", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.propertyValue").value(10000.0));
    }

    @Test
    public void getPropertyValueWithNonExistingProperty() throws Exception {
        Mockito.when(iPropertyRepository.findPropertyById(1)).thenThrow(new PropertyNotFoundException(1));
        String expectedDescription = "El id 1 no pertenece a una propiedad registrada";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getPropertyValue/{propertyId}", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }

    @Test
    public void getBiggestEnvironmentWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        property.setId(1);
        EnvironmentDTO environmentDTO = TestUtilGenerator.getPropertyDTO("Alto Alberdi").getEnvironments().get(0);
        environmentDTO.setSquareMeters(30.0);
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);
        Mockito.when(mapper.map(property.getEnvironments().get(0),EnvironmentDTO.class)).thenReturn(environmentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getBiggestEnvironment/{propertyId}", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggestEnvironment.name").value(environmentDTO.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggestEnvironment.squareMeters").value(30.0));
    }

    @Test
    public void getBiggestEnvironmentWithNonExistingProperty() throws Exception {
        Mockito.when(iPropertyRepository.findPropertyById(1)).thenThrow(new PropertyNotFoundException(1));
        String expectedDescription = "El id 1 no pertenece a una propiedad registrada";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getBiggestEnvironment/{propertyId}", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }

    @Test
    public void getEnvironmentsSquareMetersWithExistingProperty() throws Exception {
        Property property = TestUtilGenerator.getProperty();
        property.setId(1);
        List<EnvironmentDTO> environmentDTOS = TestUtilGenerator.getEnvironmentsDTO();
        Mockito.when(iPropertyRepository.findPropertyById(property.getId())).thenReturn(property);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getEnvironmentsSquareMeters/{propertyId}", property.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSquareMeters[0].name").value(environmentDTOS.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.environmentsSquareMeters[0].squareMeters").value(environmentDTOS.get(0).getSquareMeters()));
    }

    @Test
    public void getEnvironmentsSquareMetersWithNonExistingProperty() throws Exception {
        Mockito.when(iPropertyRepository.findPropertyById(1)).thenThrow(new PropertyNotFoundException(1));
        String expectedDescription = "El id 1 no pertenece a una propiedad registrada";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/appraisals/getEnvironmentsSquareMeters/{propertyId}", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(expectedDescription));
    }
}

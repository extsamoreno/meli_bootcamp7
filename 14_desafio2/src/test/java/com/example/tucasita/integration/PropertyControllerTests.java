package com.example.tucasita.integration;

import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.model.EnvironmentDTO;
import com.example.tucasita.model.PropertyDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.repository.PropertyDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DistrictDAO districtDAO;

    @MockBean
    PropertyDAO propertyDAO;

    @Test
    public void testAddOneProperty() throws Exception {
        //ARRANGE
        String districtName = "Caballito";
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO property = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO response = new ResponseDTO(201, "La propiedad se ha agregado con éxito al repositorio local");
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(property);
        String responseJson = writer.writeValueAsString(response);

        Mockito.doNothing().when(propertyDAO).create(property);
        Mockito.when(districtDAO.findByName(districtName)).thenReturn(new DistrictDTO("Caballito", 100.0));

        //ACT

        //ASSERT
        this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/addOne")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(content().json(responseJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCalculatePropertyTotalSquareMeters() throws Exception {
        //ARRANGE
        int idProperty = 5;
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO property = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO response = new ResponseDTO(200, "La propiedad con ID 5 tiene un total de 500.0 metros cuadrados.");
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(response);

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(property);

        //ACT

        //ASSERT
        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/calculateTotalSquareMeters")
                .param("idProperty", String.valueOf(idProperty)))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseJson))
                .andExpect(status().isOk());

    }

    @Test
    public void testCalculatePropertyPrice() throws Exception {
        //ARRANGE
        int idProperty = 5;
        String districtName = "Caballito";
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO property = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO response = new ResponseDTO(200, "La propiedad con ID 5 tiene un valor de 50000.0 U$S.");
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(response);

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(property);
        Mockito.when(districtDAO.findByName(districtName)).thenReturn(new DistrictDTO("Caballito", 100.0));

        //ACT

        //ASSERT
        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/calculatePrice")
                .param("idProperty", String.valueOf(idProperty)))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseJson))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetBiggestEnvironment() throws Exception {
        //ARRANGE
        int idProperty = 5;
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO property = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        ResponseDTO response = new ResponseDTO(200, "El ambiente más grande de la propiedad con ID 5 es el ambiente Comedor con un total de 300.0 metros cuadrados.");
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(response);

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(property);

        //ACT

        //ASSERT
        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/biggestEnvironment")
                .param("idProperty", String.valueOf(idProperty)))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseJson))
                .andExpect(status().isOk());

    }

    @Test
    public void testCalculateEnvironmentsSquareMeters() throws Exception {
        //ARRANGE
        int idProperty = 5;
        String districtName = "Caballito";
        List<EnvironmentDTO> propertyEnvironments = new ArrayList<>();
        propertyEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, null));
        propertyEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, null));
        PropertyDTO property = new PropertyDTO(5, "Torre Rivadavia", "Caballito", propertyEnvironments);
        List<EnvironmentDTO> expectedEnvironments = new ArrayList<>();
        expectedEnvironments.add(new EnvironmentDTO("Living", 10.00, 20.00, 200.0));
        expectedEnvironments.add(new EnvironmentDTO("Comedor", 15.00, 20.00, 300.0));
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(expectedEnvironments);

        Mockito.when(propertyDAO.findById(idProperty)).thenReturn(property);

        //ACT

        //ASSERT
        this.mockMvc.perform(MockMvcRequestBuilders.get("/properties/calculateEnvironmentsSquareMeters")
                .param("idProperty", String.valueOf(idProperty)))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(responseJson))
                .andExpect(status().isOk());

    }
}

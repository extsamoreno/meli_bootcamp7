package desafio2.demo.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import desafio2.demo.exception.DistrictNotFoundException;
import desafio2.demo.model.DistrictDTO;
import desafio2.demo.model.EnvironmentDTO;
import desafio2.demo.model.PropertyDTO;
import desafio2.demo.repository.IPropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerAndServiceTest {
    PropertyDTO propertyDTO;
    EnvironmentDTO smallEnvironment;
    EnvironmentDTO bigEnvironment;
    DistrictDTO districtDTOnotFound;
    String standardPayloaod;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    //Arrange methods to reduce code duplication

    void arrangeHappyPath() throws JsonProcessingException, DistrictNotFoundException {
        smallEnvironment = new EnvironmentDTO("Env1",3,3);
        bigEnvironment = new EnvironmentDTO("Env2",25,3);
        propertyDTO = new PropertyDTO("Propiedad 1",new DistrictDTO("Palermo", 500),new ArrayList<>(){{
            add(smallEnvironment);
            add(bigEnvironment);
        }});
        Mockito.doNothing().when(iPropertyRepository).validateDistrict(Mockito.any(DistrictDTO.class));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        standardPayloaod = writer.writeValueAsString(this.propertyDTO);
    }

    void arrangeDistrictNotFound() throws JsonProcessingException, DistrictNotFoundException {
        smallEnvironment = new EnvironmentDTO("Env1",3,3);
        bigEnvironment = new EnvironmentDTO("Env2",25,3);
        districtDTOnotFound = new DistrictDTO("Palermoww", 500);
        propertyDTO = new PropertyDTO("Propiedad 1",districtDTOnotFound,new ArrayList<>(){{
            add(smallEnvironment);
            add(bigEnvironment);
        }});
        Mockito.doThrow(new DistrictNotFoundException(districtDTOnotFound)).when(iPropertyRepository).validateDistrict(districtDTOnotFound);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        standardPayloaod = writer.writeValueAsString(this.propertyDTO);
    }

    void arrangeValidationError() throws JsonProcessingException {
        smallEnvironment = new EnvironmentDTO("Env1",3,3);
        bigEnvironment = new EnvironmentDTO("Env2",250,3);
        propertyDTO = new PropertyDTO("Propiedad 1",new DistrictDTO("Palermo", 500),new ArrayList<>(){{
            add(smallEnvironment);
            add(bigEnvironment);
        }});

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        standardPayloaod = writer.writeValueAsString(this.propertyDTO);
    }

    //Test all Happy Paths

    @Test
    void getTotalM2() throws Exception {
        arrangeHappyPath();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/totalM2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(standardPayloaod))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("84.0"))
                .andReturn();
    }

    @Test
    void getTotalPrice() throws Exception {
        arrangeHappyPath();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/totalPrice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(standardPayloaod))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("42000.0"))
                .andReturn();
    }

    @Test
    void getBiggestEnvironment() throws Exception {
        arrangeHappyPath();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/biggestEnvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(standardPayloaod))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("{\"name\":\"Env2\",\"width\":25.0,\"length\":3.0}"))
                .andReturn();
    }

    @Test
    void getEnvironmentsArea() throws Exception {
        arrangeHappyPath();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/environmentsArea")
                .contentType(MediaType.APPLICATION_JSON)
                .content(standardPayloaod))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("[{\"name\":\"Env1\",\"width\":3.0,\"length\":3.0,\"area\":9.0},{\"name\":\"Env2\",\"width\":25.0,\"length\":3.0,\"area\":75.0}]"))
                .andReturn();
    }

    //Test errors. We are only testing with the getTotalM2 method since here the purpose is to test mainly the exception controller, which wasn't unit tested.

    @Test
    void getTotalM2ValidationError() throws Exception {
        arrangeValidationError();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/totalM2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(standardPayloaod))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("[{\"message\":\"El mÃ¡ximo ancho permitido por propiedad es de 25 mts.\",\"name\":\"Validation error on property: environments[1].width\"}]"))
                .andReturn();
    }

    @Test
    void getTotalM2DistrictNotFoundError() throws Exception {
        arrangeDistrictNotFound();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/totalM2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(standardPayloaod))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(content().string("{\"message\":\"District Palermoww with price 500.0USD was not found\",\"name\":\"DistrictNotFoundException\"}"))
                .andReturn();
    }

    @Test
    void getTotalM2JSONParseError() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/property/totalM2")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{{{{´´´´´"))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("The provided JSON can't be parsed. Please check that you are providing only the correct properties with the correct values"))
                .andReturn();
    }
}

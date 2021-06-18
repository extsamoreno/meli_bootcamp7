package com.example.challenge_2.integration;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.Property;
import com.example.challenge_2.repository.IDistrictRepository;
import com.example.challenge_2.repository.IPropertyRepository;
import com.example.challenge_2.service.dto.PropertyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPropertyRepository propertyRepository;

    @MockBean
    private IDistrictRepository districtRepository;

    @Test
    public void createPropertyTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        Property property = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        when(districtRepository.getByName(property.getDistrict().getName())).thenReturn(property.getDistrict());
        when(propertyRepository.add(property)).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void createPropertyDistrictNotFoundTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        when(districtRepository.getByName("Centro")).thenThrow(DistrictNotFoundException.class);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void createPropertyBadNameTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setName("asdasd");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameLengthTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setName("Asdkfljdfhsldfkjsdlfkjsdlfkjsdlfkjsdflksdjflksdjflksdfjsdasd");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameEmptyTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setName("");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadEnvironmentTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setEnvironments(new ArrayList<>());

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameEnvironmentTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setName("bad name");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameLengthEnvironmentTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setName("Basdadasdasdasdjaksdskjgfbhdfkgbdfkgnjdfkgdfngkdfngkdfg");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameEmptyEnvironmentTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setName("");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadLengthEnvironmentTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setLength(1000);

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadWidthEnvironmentTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setWidth(100);

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameLengthDistrictTest() throws Exception{
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getDistrict().setName("Basdadasdasdasdjaksdskjgfbhdfkgbdfkgnjdfkgdfngkdfngkdfgasdasdasdasdasasdasdasdadsasdasdasdasdasdasd");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }


}

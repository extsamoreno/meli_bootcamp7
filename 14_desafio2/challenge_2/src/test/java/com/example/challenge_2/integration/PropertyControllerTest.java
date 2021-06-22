package com.example.challenge_2.integration;

import com.example.challenge_2.Util.TestUtilsGenerator;
import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.exception.PropertyNotFoundException;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    public void createPropertyTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        Property property = TestUtilsGenerator.getPropertyWithFourEnvironmentTest();

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        when(districtRepository.getByName(property.getDistrict().getName())).thenReturn(property.getDistrict());
        when(propertyRepository.add(property)).thenReturn(true);

        this.mockMvc.perform(post("/property/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void createPropertyDistrictNotFoundTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        when(districtRepository.getByName("Centro")).thenThrow(new DistrictNotFoundException("Centro"));

        this.mockMvc.perform(post("/property")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void createPropertyBadNameTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setName("asdasd");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameLengthTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setName("Asdkfljdfhsldfkjsdlfkjsdlfkjsdlfkjsdflksdjflksdjflksdfjsdasd");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameEmptyTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setName("");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadEnvironmentTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.setEnvironments(new ArrayList<>());

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameEnvironmentTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setName("bad name");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameLengthEnvironmentTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setName("Basdadasdasdasdjaksdskjgfbhdfkgbdfkgnjdfkgdfngkdfngkdfg");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameEmptyEnvironmentTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setName("");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadLengthEnvironmentTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setLength(1000);

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadWidthEnvironmentTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getEnvironments().stream().findFirst().get().setWidth(100);

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void createPropertyBadNameLengthDistrictTest() throws Exception {
        PropertyDTO propertyDTO = TestUtilsGenerator.getPropertyDTOWithFourEnvironmentTest();

        propertyDTO.getDistrict().setName("Basdadasdasdasdjaksdskjgfbhdfkgbdfkgnjdfkgdfngkdfngkdfgasdasdasdasdasasdasdasdadsasdasdasdasdasdasd");

        String payloadJson = TestUtilsGenerator.makeObjectJsonString(propertyDTO);

        this.mockMvc.perform(post("/property/")
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    //get-square-meters/{propertyId}
    @Test
    public void getSquareMetersTest() throws Exception {

        when(propertyRepository.getById(1)).thenReturn(TestUtilsGenerator.getPropertyWithFourEnvironmentTest());

        this.mockMvc.perform(get("/property/get-square-meters/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.squareMeters").value(285.0));
    }

    @Test
    public void getSquareMetersPropertyNotFoundTest() throws Exception {

        when(propertyRepository.getById(1)).thenThrow(new PropertyNotFoundException(1));

        this.mockMvc.perform(get("/property/get-square-meters/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getPropertyPriceTest() throws Exception {

        when(propertyRepository.getById(1)).thenReturn(TestUtilsGenerator.getPropertyWithFourEnvironmentTest());
        when(districtRepository.getByName("Centro")).thenReturn(TestUtilsGenerator.getDistrictTest());

        this.mockMvc.perform(get("/property/get-property-price/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.finalPrice").value(2850.0));
    }

    @Test
    public void getPropertyPricePropertyNotFoundTest() throws Exception {

        when(propertyRepository.getById(1)).thenThrow(new PropertyNotFoundException(1));

        this.mockMvc.perform(get("/property/get-property-price/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getBiggestEnvironmentTest() throws Exception {

        when(propertyRepository.getById(1)).thenReturn(TestUtilsGenerator.getPropertyWithFourEnvironmentTest());

        this.mockMvc.perform(get("/property/get-biggest-environment/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Kitchen"))
                .andExpect(jsonPath("$.width").value(25.0))
                .andExpect(jsonPath("$.length").value(5.0));
    }

    @Test
    public void getBiggestEnvironmentPropertyNotFoundTest() throws Exception {

        when(propertyRepository.getById(1)).thenThrow(new PropertyNotFoundException(1));

        this.mockMvc.perform(get("/property/get-biggest-environment/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getSquareMetersEachEnvironmentTest() throws Exception {

        when(propertyRepository.getById(1)).thenReturn(TestUtilsGenerator.getPropertyWithFourEnvironmentTest());

        this.mockMvc.perform(get("/property/get-square-meters-each-environment/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].name").value("Room"))
                .andExpect(jsonPath("$.[0].squareMeters").value(35.0))
                .andExpect(jsonPath("$.[1].name").value("Kitchen"))
                .andExpect(jsonPath("$.[1].squareMeters").value(125.0))
                .andExpect(jsonPath("$.[2].name").value("Living"))
                .andExpect(jsonPath("$.[2].squareMeters").value(25.0))
                .andExpect(jsonPath("$.[3].name").value("Bathroom"))
                .andExpect(jsonPath("$.[3].squareMeters").value(100.0));
    }

    @Test
    public void getSquareMetersEachEnvironmentPropertyNotFoundTest() throws Exception {

        when(propertyRepository.getById(1)).thenThrow(new PropertyNotFoundException(1));

        this.mockMvc.perform(get("/property/get-square-meters-each-environment/{propertyId}", 1)
                .accept(MediaType.ALL)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}

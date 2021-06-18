package com.meli.tucasita.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.tucasita.dto.PropertyDTO;
import com.meli.tucasita.exception.InvalidDistrictException;
import com.meli.tucasita.exception.PropertyAlreadyExistsException;
import com.meli.tucasita.repository.DistrictRepositoryImpl;
import com.meli.tucasita.repository.PropertyRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.meli.tucasita.util.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertiesServiceControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PropertyRepositoryImpl propertyRepository;

    @MockBean
    DistrictRepositoryImpl districtRepository;

    private static final String PROPERTY_ALREADY_EXISTS_EXCEPTION_BODY = "{\"Message\":\"ERROR: The entered Property already exists in database\",\"Name\":\"PropertyAlreadyExistsException\"}";
    private static final String INVALID_DISTRICT_EXCEPTION_BODY = "{\"Message\":\"ERROR: The entered district name does not match with any valid District\",\"Name\":\"InvalidDistrictException\"}";

    static ObjectWriter createWriter() {
        return new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void calculateSquareMetersOk() throws Exception {

        String expectedContent = "El total de metros cuadrados de la propiedad es de 41.5 m2";
        String jsonRequestDTO = createWriter().writeValueAsString(createRoomsDTO());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/squareMeters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(expectedContent))
                .andReturn();
    }

    @Test
    void calculatePropertyPriceOk() throws Exception {

        String expectedContent = "El valor total de la propiedad es de USD$ 70550.0";
        String jsonRequestDTO = createWriter().writeValueAsString(createPropertyPriceRequestDTO());

        when(districtRepository.getDistrictByName("Caballito")).thenReturn(createDistrict());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(expectedContent))
                .andReturn();
    }

    @Test
    void calculatePropertyPriceThrowsInvalidDistrictException() throws Exception {

        String errorBody = "{\"Message\":\"ERROR: The entered district name does not match with any valid District\",\"Name\":\"InvalidDistrictException\"}";
        String jsonRequestDTO = createWriter().writeValueAsString(createPropertyPriceRequestDTO());

        when(districtRepository.districtNameNotExists(createPropertyPriceRequestDTO().getDistrict())).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/price")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidDistrictException))
                .andExpect(result -> assertEquals(errorBody, result.getResponse().getContentAsString()))
                .andReturn();
    }

    @Test
    void getBiggestRoomOk() throws Exception {

        String expectedContent = "El ambiente más grande de la propiedad es Comedor, que tiene un área de 16.0 m2";
        String jsonRequestDTO = createWriter().writeValueAsString(createRoomsDTO());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/biggestRoom")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(expectedContent))
                .andReturn();
    }

    @Test
    void getRoomsAreasOk() throws Exception {

        String jsonRequestDTO = createWriter().writeValueAsString(createRoomsDTO());
        String jsonResponseDTO = createWriter().writeValueAsString(createRoomAreaDTOList());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/roomsAreas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(jsonResponseDTO))
                .andReturn();
    }

    @Test
    void insertNewPropertyOk() throws Exception {

        String jsonRequestDTO = createWriter().writeValueAsString(createPropertyDTO());
        String expectedContent = "La propiedad se ha registrado correctamente";

        when(propertyRepository.propertyAlreadyExists(createPropertyDTO().getName())).thenReturn(false);
        when(districtRepository.districtNameNotExists(createPropertyDTO().getName())).thenReturn(false);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/registerNewProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(expectedContent))
                .andReturn();
    }

    @Test
    void insertNewPropertyThrowsPropertyAlreadyExistsException() throws Exception {

        String jsonRequestDTO = createWriter().writeValueAsString(createPropertyDTO());

        when(propertyRepository.propertyAlreadyExists(createPropertyDTO().getName())).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/registerNewProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof PropertyAlreadyExistsException))
                .andExpect(result -> assertEquals(PROPERTY_ALREADY_EXISTS_EXCEPTION_BODY, result.getResponse().getContentAsString()))
                .andReturn();
    }

    @Test
    void insertNewPropertyThrowsInvalidDistrictException() throws Exception {

        String jsonRequestDTO = createWriter().writeValueAsString(createPropertyDTO());

        when(propertyRepository.propertyAlreadyExists(createPropertyPriceRequestDTO().getDistrict())).thenReturn(false);
        when(districtRepository.districtNameNotExists(createPropertyPriceRequestDTO().getDistrict())).thenReturn(true);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/registerNewProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequestDTO))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InvalidDistrictException))
                .andExpect(result -> assertEquals(INVALID_DISTRICT_EXCEPTION_BODY, result.getResponse().getContentAsString()))
                .andReturn();
    }

    @Test
    public void insertNewPropertyNullRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/registerNewProperty"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void registerNewPropertyEmptyProperty() throws Exception {
        String emptyDTO = createWriter().writeValueAsString(new PropertyDTO());

        this.mockMvc.perform(MockMvcRequestBuilders.post("/property/registerNewProperty")
                .contentType(MediaType.APPLICATION_JSON)
                .content(emptyDTO))
                .andDo(print()).andExpect(status().isBadRequest());
    }

}

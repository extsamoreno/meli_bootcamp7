package com.meli.desafio.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.desafio.exceptions.dto.ErrorDTO;
import com.meli.desafio.exceptions.models.DistrictAlreadyExists;
import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.models.District;
import com.meli.desafio.models.dto.DistrictRequestDTO;
import com.meli.desafio.repositories.ICalculateRepository;
import com.meli.desafio.utils.Mappers;
import com.meli.desafio.utils.TestUtils;
import com.meli.desafio.utils.URLBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DistrictControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICalculateRepository districtRepository;

    private final ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();


    @Test
    public void addDistrictShouldThrowExceptionWhenNameIsNull() throws Exception {
        DistrictRequestDTO district = DistrictRequestDTO.builder()
                .name(null)
                .price(100.0)
                .build();
        ErrorDTO error = TestUtils.getValidationError("The district must have a name");
        callForValidationErrorAddHouse(district, error);
    }

    @Test
    public void addDistrictShouldThrowExceptionWhenNameHaveMoreThan45Chars() throws Exception {
        DistrictRequestDTO district = DistrictRequestDTO.builder()
                .name("A".repeat(46))
                .price(1000.0)
                .build();
        ErrorDTO error = TestUtils.getValidationError("The name of the district cannot contain more than 45 characters");
        callForValidationErrorAddHouse(district, error);
    }

    @Test
    public void addDistrictShouldThrowExceptionWhenPriceIsBiggerTo4000() throws Exception {
        DistrictRequestDTO district = DistrictRequestDTO.builder()
                .name("District")
                .price(5000.00)
                .build();
        ErrorDTO error = TestUtils.getValidationError("The price cant be higher of 4000");
        callForValidationErrorAddHouse(district, error);
    }

    @Test
    public void addDistrictShouldThrowExceptionWhenPriceIsLowerToZero() throws Exception {
        DistrictRequestDTO district = DistrictRequestDTO.builder()
                .name("District")
                .price(-2)
                .build();
        ErrorDTO error = TestUtils.getValidationError("The price cannot be less than or equal to 0");
        callForValidationErrorAddHouse(district, error);
    }

    @Test
    public void addDistrictShouldThrowExceptionWhenDistrictNameALreadyExists() throws Exception {
        DistrictRequestDTO district = DistrictRequestDTO.builder()
                .name("Avellaneda")
                .price(1000.0)
                .build();
        DistrictAlreadyExists expcetion = new DistrictAlreadyExists(district.getName());
        when(districtRepository.saveDistrict(district)).thenThrow(expcetion);

        String payloadJson = writer.writeValueAsString(district);

        String error = writer.writeValueAsString(expcetion.getError());


        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/district")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();
    }

    public void callForValidationErrorAddHouse(DistrictRequestDTO district, ErrorDTO errorDTO) throws Exception {
        when(districtRepository.saveDistrict(district)).thenReturn(1);

        String payloadJson = writer.writeValueAsString(district);

        String error = writer.writeValueAsString(errorDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/district")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(error))
                .andReturn();

        verify(districtRepository, atMost(0)).saveDistrict(district);
    }

    @Test
    public void addDistrictHappyPath() throws Exception {
        DistrictRequestDTO district = DistrictRequestDTO.builder()
                .name("District")
                .price(1000.0)
                .build();
        when(districtRepository.saveDistrict(district)).thenReturn(1);
        String payloadJson = writer.writeValueAsString(district);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/district")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(URLBuilder.buildURL("district", 1, "")))
                .andReturn();

        verify(districtRepository, atMost(1)).saveDistrict(district);
    }

    @Test
    public void getDistrictHappyPath() throws Exception {
        Integer districtId = 1;
        District district = TestUtils.getDistrict("District");
        when(districtRepository.getDistrict(districtId)).thenReturn(district);
        String expected = writer.writeValueAsString(Mappers.districtToDTO(district));

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/district/{id}", districtId))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(expected))
                .andReturn();
    }

    @Test
    public void getDistrictShouldThrowDistintNotFoundException() throws Exception {
        Integer districtId = 1;
        DistrictNotFoundException exception = new DistrictNotFoundException(districtId);
        when(districtRepository.getDistrict(districtId)).thenThrow(exception);
        String expected = writer.writeValueAsString(exception.getError());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/district/{id}", districtId))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(expected))
                .andReturn();
    }
}

package com.tuCasita.api.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tuCasita.api.dto.DistrictDTO;
import com.tuCasita.api.dto.PropertyDTO;
import com.tuCasita.api.exception.dto.ErrorDTO;
import com.tuCasita.api.exception.exception.DistrictNameNotFoundException;
import com.tuCasita.api.repository.contract.IPropertyRepository;
import com.tuCasita.api.testUtil.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPropertyRepository iPropertyRepository;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    public void getTotalSquareMetersWithValidDTOShouldReturnOk() throws Exception{
        PropertyDTO dto = TestUtil.getPropertyDTOWith3Environments();
        var expectedDTO = TestUtil.getPropertyWithTotalSquareMeters();
        when(iPropertyRepository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());

        String payloadJson = writer.writeValueAsString(dto);
        String expectedJson = writer.writeValueAsString(expectedDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/totalsquaremeters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getTotalSquareMetersWithInvalidDistrictShouldReturnOk() throws Exception{
        PropertyDTO dto = TestUtil.getPropertyDTOWith3Environments();
        String incorrectDistrictName = "Incorrect name";
        dto.setDistrict(new DistrictDTO(incorrectDistrictName, 10.0));
        var exception = new DistrictNameNotFoundException(incorrectDistrictName);
        when(iPropertyRepository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());

        String payloadJson = writer.writeValueAsString(dto);
        String expectedJson = writer.writeValueAsString(exception.getError());

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/totalsquaremeters")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getTotalValueWithValidDTOShouldReturnOk() throws Exception {
        PropertyDTO dto = TestUtil.getPropertyDTOWith3Environments();
        var expectedDTO = TestUtil.getPropertyWithTotalValue();
        when(iPropertyRepository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());

        String payloadJson = writer.writeValueAsString(dto);
        String expectedJson = writer.writeValueAsString(expectedDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/totalvalue")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void getBiggestEnvironmentWithValidDTOShouldReturnOk() throws Exception {
        PropertyDTO dto = TestUtil.getPropertyDTOWith3EnvironmentsOneBiggest();
        var expectedDTO = TestUtil.getPropertyWithBiggestEnvironment();
        when(iPropertyRepository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());

        String payloadJson = writer.writeValueAsString(dto);
        String expectedJson = writer.writeValueAsString(expectedDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/biggestenvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void getTotalSquareMetersByEnvironmentWithValidDTOShouldReturnOk() throws Exception {
        PropertyDTO dto = TestUtil.getPropertyDTOWith3Environments();
        var expectedDTO = TestUtil.getPropertyWithTotalSquareMetersByEnvironment();
        when(iPropertyRepository.getAllDistrictNames()).thenReturn(TestUtil.getDistrictNames());

        String payloadJson = writer.writeValueAsString(dto);
        String expectedJson = writer.writeValueAsString(expectedDTO);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/properties/totalsquaremetersbyenvironment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, mvcResult.getResponse().getContentAsString());

    }

}

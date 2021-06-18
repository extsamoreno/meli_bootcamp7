package com.tucasitatasaciones.tucasitatasaciones.integrations;

import com.tucasitatasaciones.tucasitatasaciones.repositories.IDistrictRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.District;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OwnershipControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDistrictRepository districtRepository;

    @MockBean
    private IOwnerRepository ownerRepository;

    @Test
    public void calculatePriceByOwnershipWithDataOkTest() throws Exception {
        District expectedDistrict = new District(1, "District dummy", 20.0);

        List<Room> expectedRooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", expectedRooms, 1);

        Mockito.when(districtRepository.findAny(expectedDistrict.getId())).thenReturn(expectedDistrict);
        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ownerships/{ownershipId}/price", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(8400D)
                );

    }

    @Test
    public void calculatePriceByOwnershipWithoutOwnershipErrorTest() throws Exception {
        Mockito.when(ownerRepository.findFirst(99)).thenReturn(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ownerships/{ownershipId}/price", 99))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("OwnershipNotFoundException")
                );
    }

    @Test
    public void calculatePriceByOwnershipWithoutDistrictErrorTest() throws Exception {
        Ownership expectedOwnership = new Ownership(1, "Ownership Test", null, 99);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);
        Mockito.when(districtRepository.findAny(expectedOwnership.getId())).thenReturn(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ownerships/{ownershipId}/price", 1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("DistrictNotFoundException")
                );
    }

    @Test
    public void calculateSquareMeterByOwnershipWithDataOkTest() throws Exception {
        List<Room> expectedRooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", expectedRooms, 1);

        Mockito.when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ownerships/{ownershipId}/square-meter", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareMeter").value(420D)
                );
    }

    @Test
    public void calculateSquareMeterByOwnershipWithoutOwnershipErrorTest() throws Exception {
        Mockito.when(ownerRepository.findFirst(99)).thenReturn(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/ownerships/{ownershipId}/square-meter", 99))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("OwnershipNotFoundException")
                );
    }
}

package com.tucasitatasaciones.tucasitatasaciones.integrations;

import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import org.junit.jupiter.api.Test;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IOwnerRepository ownerRepository;

    @Test
    public void getBiggestRoomByOwnershipWithDataOkTest() throws Exception {
        //{"name":"Bedroom","high":10.0,"width":30.0,"squareMeter":300.0}
        List<Room> expectedRooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", expectedRooms, 1);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rooms/any").param("ownership", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Bedroom"));
        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
    }

    @Test
    public void getBiggestRoomByOwnershipWithoutOwnershipIdErrorTest() throws Exception {
        when(ownerRepository.findFirst(99)).thenReturn(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rooms/any").param("ownership", "99"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("OwnershipNotFoundException"));
        verify(ownerRepository, atLeastOnce()).findFirst(99);
    }

    @Test
    public void getRoomsByOwnershipWithDataOkTest() throws Exception {
        List<Room> expectedRooms = Arrays.asList(new Room(2, "Kitchen", 5.0, 3.0),
                new Room(3, "Linving", 15.0, 7.0),
                new Room(1, "Bedroom", 30.0, 10.0));

        Ownership expectedOwnership = new Ownership(1, "Ownership Test", expectedRooms, 1);

        when(ownerRepository.findFirst(expectedOwnership.getId())).thenReturn(expectedOwnership);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rooms/all").param("ownership", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(ownerRepository, atLeastOnce()).findFirst(expectedOwnership.getId());
    }

    @Test
    public void getRoomsByOwnershipWithoutOwnershipIdErrorTest() throws Exception {
        when(ownerRepository.findFirst(99)).thenReturn(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rooms/all").param("ownership", "99"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("OwnershipNotFoundException"));
        verify(ownerRepository, atLeastOnce()).findFirst(99);
    }
}

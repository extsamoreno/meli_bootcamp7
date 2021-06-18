package com.example.desafio2.unit.service.mapper;

import com.example.desafio2.model.Neighborhood;
import com.example.desafio2.model.Property;
import com.example.desafio2.model.Room;
import com.example.desafio2.service.DTO.NeighborhoodDTO;
import com.example.desafio2.service.DTO.PropertyDTO;
import com.example.desafio2.service.DTO.RoomDTO;
import com.example.desafio2.service.Mapper.PropertyMapper;
import com.example.desafio2.util.TestUtilsGenerator;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PropertyMapperTest {
    @Test
    public void roomtoRoomDTOSuccesful() {
        Room room = TestUtilsGenerator.getPropertyWith1Room("Punta").getRooms().get(0);
        RoomDTO expected = new RoomDTO(room.getName(), room.getWidth(), room.getLength());

        assertEquals(expected, PropertyMapper.roomtoRoomDTO(room));
    }

    @Test
    public void propDTOtoPropSuccesful() {
        PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith1Room("Punta");
        Property expected = new Property(prop.getName(), new Neighborhood(prop.getNeighborhood().getName(), prop.getNeighborhood().getPrice()), PropertyMapper.roomDTOtoRoom(prop.getRooms()));
        assertEquals(expected, PropertyMapper.propDTOtoProp(prop));
    }
    @Test
    public void neighborhoodDTOtoNeighborhoodSuccesful() {
        NeighborhoodDTO neighborhood = new NeighborhoodDTO("Punta", 10);
        Neighborhood expected = new Neighborhood(neighborhood.getName(), neighborhood.getPrice());
        assertEquals(expected, PropertyMapper.neighborhoodDTOtoNeighborhood(neighborhood));

    }
    @Test
    public void roomDTOtoRoom() {
        RoomDTO room = TestUtilsGenerator.getPropertyDTOWith1Room("Centro").getRooms().get(0);
        Room expected = new Room(room.getName(), room.getWidth(), room.getLength());
        assertEquals(expected, PropertyMapper.roomDTOtoRoom(room));
    }
    @Test
    public void roomDTOtoRoomSuccesful(){
        PropertyDTO prop = TestUtilsGenerator.getPropertyDTOWith1Room("Punta");
        List<RoomDTO> rooms = new LinkedList<>();
        rooms.add(prop.getRooms().get(0));
        List<Room> expected = new LinkedList<>();
        expected.add(new Room(prop.getRooms().get(0).getName(),prop.getRooms().get(0).getWidth(),prop.getRooms().get(0).getLength()));
        assertEquals(expected, PropertyMapper.roomDTOtoRoom(rooms));

    }
}

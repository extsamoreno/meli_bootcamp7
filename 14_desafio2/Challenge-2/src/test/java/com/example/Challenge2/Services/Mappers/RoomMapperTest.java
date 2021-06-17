package com.example.Challenge2.Services.Mappers;

import com.example.Challenge2.Models.Property;
import com.example.Challenge2.Models.Room;
import com.example.Challenge2.Services.DTOs.PropertyDTO;
import com.example.Challenge2.Services.DTOs.RoomDTO;
import com.example.Challenge2.Services.Mapper.PropertyMapper;
import com.example.Challenge2.Services.Mapper.RoomMapper;
import com.example.Challenge2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RoomMapperTest {

    @Test
    public void toRoomTest(){

        Room ExpectedRoom = TestUtilsGenerator.get100Mt2Room();
        RoomDTO roomDTO = new RoomDTO(ExpectedRoom.getName(),ExpectedRoom.getWidth(),ExpectedRoom.getLength());
        Room room = RoomMapper.toRoom(roomDTO);

        assertEquals(room,ExpectedRoom);
    }
    @Test
    public void toRoomSTest(){

        List<Room> ExpectedRooms = TestUtilsGenerator.getTwo25Mt2Rooms();

        RoomDTO roomDTO1 = new RoomDTO(ExpectedRooms.get(0).getName(),ExpectedRooms.get(0).getWidth(),ExpectedRooms.get(0).getLength());
        RoomDTO roomDTO2 = new RoomDTO(ExpectedRooms.get(1).getName(),ExpectedRooms.get(1).getWidth(),ExpectedRooms.get(1).getLength());
        List<RoomDTO> roomDTOS = Arrays.asList(roomDTO1,roomDTO2);


        List<Room> room = RoomMapper.toRooms(roomDTOS);

        assertEquals(room,ExpectedRooms);
    }
    @Test
    public void toDTOTest(){

        Room room = TestUtilsGenerator.get100Mt2Room();
        RoomDTO expectedRoomDTO = new RoomDTO(room.getName(),room.getWidth(),room.getLength());

        RoomDTO roomDTO = RoomMapper.toDTO(room);

        assertEquals(roomDTO,expectedRoomDTO);
    }
    @Test
    public void toDTOsTest(){

        List<Room> rooms = TestUtilsGenerator.getTwo25Mt2Rooms();

        RoomDTO roomDTO1 = new RoomDTO(rooms.get(0).getName(),rooms.get(0).getWidth(),rooms.get(0).getLength());
        RoomDTO roomDTO2 = new RoomDTO(rooms.get(1).getName(),rooms.get(1).getWidth(),rooms.get(1).getLength());
        List<RoomDTO> expectedRoomDTO = Arrays.asList(roomDTO1,roomDTO2);

        List<RoomDTO> roomsDTOs = RoomMapper.toDTOs(rooms);

        assertEquals(roomsDTOs,expectedRoomDTO);
    }
}

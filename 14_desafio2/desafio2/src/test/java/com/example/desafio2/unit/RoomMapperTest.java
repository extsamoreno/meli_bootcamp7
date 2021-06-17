package com.example.desafio2.unit;

import com.example.desafio2.dtos.PropertyDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.exceptions.DistrictIdNotValidException;
import com.example.desafio2.models.Room;
import com.example.desafio2.services.mappers.RoomMapper;
import com.example.desafio2.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class RoomMapperTest {

    @Test
    public void toModelHappyPath() {
        Room room = new Room("Living", 6.0, 5.0);
        RoomDTO roomDTO = new RoomDTO("Living", 6.0, 5.0);

        Assertions.assertEquals(room,RoomMapper.toModel(roomDTO));
    }

    @Test
    public void toModelListHappyPath() {
        List<Room> roomList = new ArrayList<>();
        List<RoomDTO> roomDTOList = new ArrayList<>();

        roomList.add(new Room("Living", 6.0, 5.0));
        roomList.add(new Room("Bedroom", 2.0, 5.0));
        roomList.add(new Room("Kitchen", 4.0, 3.0));

        roomDTOList.add(new RoomDTO("Living", 6.0, 5.0));
        roomDTOList.add(new RoomDTO("Bedroom", 2.0, 5.0));
        roomDTOList.add(new RoomDTO("Kitchen", 4.0, 3.0));

        Assertions.assertEquals(roomList,RoomMapper.toModelList(roomDTOList));
    }

    @Test
    public void toDTOHappyPath() {
        Room room = new Room("Living", 6.0, 5.0);
        RoomDTO roomDTO = new RoomDTO("Living", 6.0, 5.0);

        Assertions.assertEquals(roomDTO,RoomMapper.toDTO(room));
    }
}

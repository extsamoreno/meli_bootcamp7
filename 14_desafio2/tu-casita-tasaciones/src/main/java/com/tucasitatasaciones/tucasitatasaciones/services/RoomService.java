package com.tucasitatasaciones.tucasitatasaciones.services;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.repositories.IOwnerRepository;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Ownership;
import com.tucasitatasaciones.tucasitatasaciones.repositories.entities.Room;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomWithSquareMeterDTO;
import com.tucasitatasaciones.tucasitatasaciones.services.mappers.OwnershipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomService implements IRoomService {

    @Autowired
    IOwnerRepository ownerRepository;

    @Override
    public RoomWithSquareMeterDTO getBiggestRoomByOwnership(int ownershipId) throws OwnershipNotFoundException {
        var rooms = getRoomsByOwnership(ownershipId);

        var result = rooms.stream()
                .max(Comparator.comparing(RoomWithSquareMeterDTO::getSquareMeter))
                .orElseThrow(NoSuchElementException::new);

        return result;
    }

    @Override
    public List<RoomWithSquareMeterDTO> getRoomsByOwnership(int ownershipId) throws OwnershipNotFoundException {
        List<RoomWithSquareMeterDTO> result = new ArrayList<>();

        Ownership entity = ownerRepository.findFirst(ownershipId);

        if (entity == null) throw new OwnershipNotFoundException(ownershipId);

        for (Room room : entity.getRooms()) {
            var roomTemporal = OwnershipMapper.roomToRoomWithSquareMeterDTO(room);

            roomTemporal.setSquareMeter(roomTemporal.getHigh() * roomTemporal.getWidth());

            result.add(roomTemporal);
        }

        return result;
    }
}

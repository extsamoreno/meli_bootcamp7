package com.tucasitatasaciones.tucasitatasaciones.services;

import com.tucasitatasaciones.tucasitatasaciones.exceptions.OwnershipNotFoundException;
import com.tucasitatasaciones.tucasitatasaciones.services.dtos.RoomWithSquareMeterDTO;

import java.util.List;

public interface IRoomService {
    RoomWithSquareMeterDTO getBiggestRoomByOwnership(int ownershipId) throws OwnershipNotFoundException;

    List<RoomWithSquareMeterDTO> getRoomsByOwnership(int ownershipId) throws OwnershipNotFoundException;
}

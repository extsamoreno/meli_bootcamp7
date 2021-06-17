package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.dto.RoomSquareMetersDTO;
import com.tucasita.tasaciones.exception.NeighborhoodNotFoundException;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;

import java.io.IOException;
import java.util.List;

public interface PropertyService {

    void saveProperty(PropertyDTO property) throws IOException, NeighborhoodNotFoundException;
    Double calculateSquareMeters(int id) throws PropertyNotFoundException;
    Double getPropertyPrice(int id) throws PropertyNotFoundException;
    RoomDTO getBiggestRoom(int id) throws PropertyNotFoundException;
    List<RoomSquareMetersDTO> getRoomsSquareMeters(int id) throws PropertyNotFoundException;
}

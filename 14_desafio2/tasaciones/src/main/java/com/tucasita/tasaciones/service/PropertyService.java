package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;

import java.io.IOException;

public interface PropertyService {

    void saveProperty(PropertyDTO property) throws IOException;
    Double calculateSquareMeters(int id) throws PropertyNotFoundException;
    Double getPropertyPrice(int id) throws PropertyNotFoundException;
    RoomDTO getBiggestRoom(int id) throws PropertyNotFoundException;
}

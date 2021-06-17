package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.model.Room;
import com.tucasita.tasaciones.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public void saveProperty(PropertyDTO property) throws IOException {
        propertyRepository.saveProperty(PropertyMapper.toEntity(property));
    }

    @Override
    public Double calculateSquareMeters(int id) throws PropertyNotFoundException {
        Property prop = propertyRepository.getPropertyById(id);
        return prop.getRooms().stream().mapToDouble(r -> r.getLength() * r.getWidth()).sum();
    }

    @Override
    public Double getPropertyPrice(int id) throws PropertyNotFoundException {
        Property prop = propertyRepository.getPropertyById(id);
        if (prop == null) {
            throw new PropertyNotFoundException(id);
        }

        Double squareMeters = prop.getRooms().stream().mapToDouble(r -> r.getLength() * r.getWidth()).sum();
        return squareMeters * prop.getNeighborhood().getPrice();
    }

    @Override
    public RoomDTO getBiggestRoom(int id) throws PropertyNotFoundException {
        Property property = propertyRepository.getPropertyById(id);
        Optional<Room> room = property.getRooms().stream().max(Comparator.comparingDouble(a -> a.getLength() * a.getWidth()));
        return room.map(PropertyMapper::toRoomDTO).orElse(null);
    }
}

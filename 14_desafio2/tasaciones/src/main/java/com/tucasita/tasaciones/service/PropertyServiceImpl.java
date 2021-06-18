package com.tucasita.tasaciones.service;

import com.tucasita.tasaciones.dto.PropertyAllDTO;
import com.tucasita.tasaciones.dto.PropertyDTO;
import com.tucasita.tasaciones.dto.RoomDTO;
import com.tucasita.tasaciones.dto.RoomSquareMetersDTO;
import com.tucasita.tasaciones.exception.NeighborhoodNotFoundException;
import com.tucasita.tasaciones.exception.PropertyNotFoundException;
import com.tucasita.tasaciones.model.Neighborhood;
import com.tucasita.tasaciones.model.Property;
import com.tucasita.tasaciones.model.Room;
import com.tucasita.tasaciones.repository.NeighborhoodRepository;
import com.tucasita.tasaciones.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private NeighborhoodRepository neighborhoodRepository;

    @Override
    public void saveProperty(PropertyDTO property) throws IOException, NeighborhoodNotFoundException {
        Neighborhood neighborhood = neighborhoodRepository.getByName(property.getNeighborhood());
        if (neighborhood == null) throw new NeighborhoodNotFoundException(property.getNeighborhood());
        propertyRepository.saveProperty(PropertyMapper.toEntity(property, neighborhood));
    }

    @Override
    public List<PropertyAllDTO> getAllProperties() {
        return PropertyMapper.toAllPropertiesList(propertyRepository.getAllProperties());
    }

    @Override
    public Double calculateSquareMeters(int id) throws PropertyNotFoundException {
        Property prop = propertyRepository.getPropertyById(id);
        if (prop == null) throw new PropertyNotFoundException(id);
        return prop.getRooms().stream().mapToDouble(r -> r.getLength() * r.getWidth()).sum();
    }

    @Override
    public Double getPropertyPrice(int id) throws PropertyNotFoundException {
        Property prop = propertyRepository.getPropertyById(id);
        if (prop == null) throw new PropertyNotFoundException(id);
        Double squareMeters = prop.getRooms().stream().mapToDouble(r -> r.getLength() * r.getWidth()).sum();
        return squareMeters * prop.getNeighborhood().getPrice();
    }

    @Override
    public RoomDTO getBiggestRoom(int id) throws PropertyNotFoundException {
        Property property = propertyRepository.getPropertyById(id);
        if (property == null) throw new PropertyNotFoundException(id);
        Optional<Room> room = property.getRooms().stream().max(Comparator.comparingDouble(a -> a.getLength() * a.getWidth()));
        RoomDTO room2 = PropertyMapper.toRoomDTO(room.get());
        return room.map(PropertyMapper::toRoomDTO).orElse(null);
    }

    @Override
    public List<RoomSquareMetersDTO> getRoomsSquareMeters(int id) throws PropertyNotFoundException {
        Property property = propertyRepository.getPropertyById(id);
        if (property == null) throw new PropertyNotFoundException(id);
        List<RoomSquareMetersDTO> roomsSquareMeters = new ArrayList<>();
        property.getRooms().forEach(r -> {
            roomsSquareMeters.add(PropertyMapper.toSquareMetersDTO(r));
        });
        return roomsSquareMeters;
    }
}

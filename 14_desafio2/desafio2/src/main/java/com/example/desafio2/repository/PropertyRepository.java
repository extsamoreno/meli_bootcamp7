package com.example.desafio2.repository;

import com.example.desafio2.exception.NeighborhoodExceptionNotFound;
import com.example.desafio2.exception.PropertyExceptionNotFound;
import com.example.desafio2.model.Neighborhood;
import com.example.desafio2.model.Property;
import com.example.desafio2.model.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PropertyRepository implements IPropertyRepository{
    private static List<Property> properties = new LinkedList<>();
    private static List<Neighborhood> neighborhoods = new LinkedList<>();
    static {
        Neighborhood  neighborhood1 = new Neighborhood("Centro",10);
        Neighborhood  neighborhood2 = new Neighborhood("Malvin",20);
        Neighborhood  neighborhood3 = new Neighborhood("Pocitos",30);
        neighborhoods.add(neighborhood1);
        neighborhoods.add(neighborhood2);
        neighborhoods.add(neighborhood3);
        Room room1 = new Room("Bedroom",1,1);
        Room room2 = new Room("Big Bedroom",2,2);
        Room room3 = new Room("Bathroom",1,1);
        Room room4 = new Room("Living",1,1);
        Room room5 = new Room("Big bedroom",20,20);
        List<Room> roomsProp1 = new ArrayList<>();
        roomsProp1.add(room1);
        roomsProp1.add(room2);
        roomsProp1.add(room3);
        List<Room> roomsProp2 = new ArrayList<>();
        roomsProp2.add(room1);
        roomsProp2.add(room2);
        roomsProp2.add(room3);
        roomsProp2.add(room4);
        List<Room> roomsProp3 = new ArrayList<>();
        roomsProp3.add(room5);
        Property property1 = new Property("Casa juan",neighborhood1,roomsProp1);
        Property property2 = new Property("Casa pedro",neighborhood2,roomsProp2);
        Property property3 = new Property("Casa pablo",neighborhood3,roomsProp2);
        properties.add(property1);
        properties.add(property2);
        properties.add(property3);
    }
    @Override
    public Property findPropertyByName(String name) throws PropertyExceptionNotFound {
        for(Property property : properties){
            if(property.getName().equals(name))
                return property;
        }
        throw new PropertyExceptionNotFound(name);
    }

    @Override
    public Neighborhood findNeighborhoodByName(String name) throws NeighborhoodExceptionNotFound {
        for(Neighborhood neighborhood : neighborhoods){
            if(neighborhood.getName().equals(name))
                return neighborhood;
        }
        throw new NeighborhoodExceptionNotFound(name);
    }

    @Override
    public List<Neighborhood> getNeighborhood() {
        return neighborhoods;
    }

    @Override
    public List<Property> getProperties() {
        return properties;
    }
}

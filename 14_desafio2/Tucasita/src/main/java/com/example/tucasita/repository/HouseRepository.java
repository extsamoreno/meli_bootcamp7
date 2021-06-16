package com.example.tucasita.repository;

import com.example.tucasita.domain.District;
import com.example.tucasita.domain.House;
import com.example.tucasita.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class HouseRepository implements IHouseRepository {
    @Autowired
    IDistrictRepository districtRepository;
    List<House> listOfHouse = new ArrayList<>();

    @Override
    public void loadDatabase() {
        List<District> districts = districtRepository.findAll();
        listOfHouse.add(new House("Casa 1", districts.get(0), setOf3Rooms("Ambiente", 2.0, 3.0)));
        listOfHouse.add(new House("Casa 2", districts.get(1), setOf3Rooms("Pieza", 1.0, 4.0)));
        listOfHouse.add(new House("Casa 3", districts.get(2), setOf3Rooms("Habitacion", 2.0, 5.0)));
        listOfHouse.add(new House("Casa 4", districts.get(3), setOf3Rooms("Quincho", 2.5, 3.40)));
        listOfHouse.add(new House("Casa 5", districts.get(4), setOf3Rooms("Room", 5.5, 5.0)));
    }

    @Override
    public Optional<House> findByName(String name) {
        return listOfHouse.stream().filter(district -> district.getName() == name).findFirst();
    }

    @Override
    public void save(House house) {
        listOfHouse.add(house);
    }

    @Override
    public boolean deleteByName(String name) {
        if (existsByName(name)) return listOfHouse.remove(findByName(name));
        else return false;
    }

    @Override
    public boolean existsByName(String name) {
        return this.findByName(name).isPresent();
    }

    @Override
    public List<House> findAll() {
        return listOfHouse;
    }

    private Set<Room> setOf3Rooms(String name, double num1, double num2) {
        Set<Room> rooms = new HashSet<>();
        rooms.add(new Room(name + " 1", num1, num1));
        rooms.add(new Room(name + " 2", num2, num2));
        rooms.add(new Room(name + " 3", num1, num2));
        return rooms;
    }
}

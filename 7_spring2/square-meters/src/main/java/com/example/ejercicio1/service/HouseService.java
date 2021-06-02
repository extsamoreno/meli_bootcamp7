package com.example.ejercicio1.service;

import com.example.ejercicio1.domain.House;
import com.example.ejercicio1.domain.Room;
import com.example.ejercicio1.dto.HouseDTO;
import com.example.ejercicio1.dto.RoomDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {
    private double price = 800;

    public HouseDTO getHouseDTO(House house) {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setTotalMeters(house.calculateTotalSquareMeters());
        houseDTO.setHouseValue(house.getHouseValue(price));
        houseDTO.setLargestRoom(house.findLargestRoom());
        houseDTO.setRooms(this.getRoomsDTO(house.getRooms()));
        return houseDTO;
    }

    public List<RoomDTO> getRoomsDTO(List<Room> rooms) {
        List<RoomDTO> roomsDTO = new ArrayList<>();
        for (Room r : rooms) {
            roomsDTO.add(createRoomDTO(r));
        }
        return roomsDTO;
    }

    private RoomDTO createRoomDTO(Room room) {
        return new RoomDTO(room.getName(), room.calculateSquareMeters());
    }

    public House getCasaConHabitacionMasGrande() {
        //Creo la lista de casas
        List<House> listaCasas = new ArrayList<>();
        listaCasas.add(this.createCasa("c1", 2, 2));
        listaCasas.add(this.createCasa("c2", 1, 2));
        listaCasas.add(this.createCasa("grande", 3, 2));
        //Me quedo con la lista de las habitaciones de todas las casas
        List<Room> listaHab = listaCasas.stream().flatMap(list -> list.getRooms().stream()).collect(Collectors.toList());
        //Me quedo con la habitacion mas grande de todas
        Room masGrande = listaHab.stream().max(
                Comparator.comparing(Room::calculateSquareMeters)
        ).get();
        //Retorno la casa que tiene la habitacion mas grande dentro de su lista de habitaciones
        return listaCasas.stream()
                .filter(c -> c.getRooms().contains(masGrande))
                .findFirst().get();
    }

    public House createCasa(String nombre, double n1, double n2) {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("h1", n1, n1));
        rooms.add(new Room("h1", n1, n2));
        rooms.add(new Room("h1", n1, n2));
        return new House(nombre, "lalala", rooms);
    }

}

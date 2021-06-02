package com.example.spring2.controllers;

import com.example.spring2.classes.House;
import com.example.spring2.classes.Room;
import com.example.spring2.dto.HouseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/houses")
public class HouseController {
    private final double COST_PER_SQUARE_METER = 800.00;
    private HashMap<String, House> houseMap = new HashMap<>();

    @PostMapping("/create") //RequestBody houseDTO que tienen name y address y hacer new House(houseDTO)
    public ResponseEntity<House> createHouse(@RequestBody HouseDTO houseDTO) {
        House h = new House(houseDTO);
        houseMap.put(h.getName(), h);
        return new ResponseEntity(h, HttpStatus.CREATED);
    }

    @PostMapping("/{houseName}/add/room")
    public ResponseEntity<Room> addRoom(@PathVariable String houseName,
                                        @RequestBody Room room) {
        House h = houseMap.get(houseName);
        Room r = new Room(room.getName(), room.getWide(), room.getLarge());
        h.addRoom(r);
        return new ResponseEntity(r, HttpStatus.CREATED);
    }

    @GetMapping("/{houseName}/squareMeters")
    public ResponseEntity<Double> getSquareMeters(@PathVariable String houseName) {
        double size = 0.00;
        House h = houseMap.get(houseName);
        HashMap<String, Room> hashmap = h.getRooms();

        for(Map.Entry<String, Room> entry : hashmap.entrySet()) {
            size += entry.getValue().getSquareMeters();
        }
        return new ResponseEntity(size, HttpStatus.OK);
    }

    @GetMapping("/{houseName}/value")
    public ResponseEntity<Double> getHouseValue(@PathVariable String houseName) {
        double totalSquareMeters = getSquareMeters(houseName).getBody();
        double price = totalSquareMeters * COST_PER_SQUARE_METER;

        return new ResponseEntity(price, HttpStatus.OK);
    }

    @GetMapping("/{houseName}/largerRoom")
    public ResponseEntity<Room> getLargerRoom(@PathVariable String houseName) {
        double max = -1.00;
        double auxMeters;
        Room largerRoom = null;
        House h = houseMap.get(houseName);
        HashMap<String, Room> hashmap = h.getRooms();

        for(Map.Entry<String, Room> entry : hashmap.entrySet()) {
            auxMeters = entry.getValue().getSquareMeters();
            if(max < auxMeters) {
                largerRoom = entry.getValue();
                max = auxMeters;
            }
        }
        return new ResponseEntity(largerRoom, HttpStatus.OK);
    }

    @GetMapping("/{houseName}/rooms/squareMeters")
    public ResponseEntity<String> getSquareMetersPerRoom(@PathVariable String houseName) {
        StringBuilder sb = new StringBuilder();
        House h = houseMap.get(houseName);
        HashMap<String, Room> hashmap = h.getRooms();

        sb.append("House: " + houseName + "\n");

        for(Map.Entry<String, Room> entry : hashmap.entrySet()) {
            sb.append("Room: " + entry.getKey() + " - m^2: " + entry.getValue().getSquareMeters() + "\n");

        }

        return new ResponseEntity(sb.toString(), HttpStatus.OK);
    }
}

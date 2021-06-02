package com.apiSpring3.controllers;

import com.apiSpring3.dtos.BiggestRoomDTO;
import com.apiSpring3.dtos.HouseTotalSquaresDTO;
import com.apiSpring3.dtos.HouseTotalValueDTO;
import com.apiSpring3.entity.House;
import com.apiSpring3.entity.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Test ok", HttpStatus.OK);
    }

    @GetMapping("/example")
    public ResponseEntity<House> getHouse(){
        House house = new House(
                "casa 1",
                "calle1 123",
                new Room[]{
                        new Room("baño", 10, 2),
                        new Room("cocina", 15, 3)});

        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @PostMapping("/calculateTotalSquares")
    public ResponseEntity<HouseTotalSquaresDTO> calculateTotalSquares (@RequestBody House house){
        var dto = new HouseTotalSquaresDTO(House.calculateTotalSquareMeters(house.getRooms()));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/calculateTotalValue")
    public ResponseEntity<HouseTotalValueDTO> calculateTotalValue(@RequestBody House house){
        var dto = new HouseTotalValueDTO(House.calculateTotalValue(house));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/returnBiggestRoom")
    public ResponseEntity<BiggestRoomDTO> returnBiggestRoom(@RequestBody House house){
        var biggestRoom = House.getBiggestRoom(house);
        var dto = new BiggestRoomDTO(biggestRoom.getName(), biggestRoom.getWidth(), biggestRoom.getLength());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

//    @PostMapping("/calculateSquareMeters")
//    public ResponseEntity<HouseSquareMetersDTO> calculateSquareMeters(@RequestBody House house){
//
//    }
}

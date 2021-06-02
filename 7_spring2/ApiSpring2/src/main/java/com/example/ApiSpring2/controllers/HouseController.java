package com.example.ApiSpring2.controllers;

import com.example.ApiSpring2.entities.Room;
import com.example.ApiSpring2.entities.SquareMeterRoom;
import com.example.ApiSpring2.services.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/house")
public class HouseController {
    HouseService service = new HouseService();
    public HouseController(){
        service.mockDB();
    }
    @GetMapping("/meters/{id}")
    public ResponseEntity<Integer> getMeters(@PathVariable("id") Integer id){
        return new ResponseEntity<Integer>(service.getSquareMeters(service.getHouse(id).getRooms()), HttpStatus.OK);
    }

    @GetMapping("/meters/price/{id}")
    public ResponseEntity<Integer> getPrice(@PathVariable("id") Integer id){
        return new ResponseEntity<Integer>(service.getPrice(service.getHouse(id).getRooms()), HttpStatus.OK);
    }

    @GetMapping("/room/bigest/{id}")
    public ResponseEntity<Room> getBigestRoom(@PathVariable("id") Integer id){
        return new ResponseEntity<Room>(service.getMaxHabitacion(service.getHouse(id).getRooms()), HttpStatus.OK);
    }

    @GetMapping("/room/meters/{id}")
    public ResponseEntity<ArrayList<SquareMeterRoom>> getMetersByRoom(@PathVariable("id") Integer id){
        return new ResponseEntity<ArrayList<SquareMeterRoom>>(service.getSquareMeterByRoom(service.getHouse(id).getRooms()), HttpStatus.OK);
    }
}

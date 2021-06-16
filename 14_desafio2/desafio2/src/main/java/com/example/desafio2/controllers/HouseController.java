package com.example.desafio2.controllers;

import com.example.desafio2.dtos.HouseDTO;
import com.example.desafio2.dtos.RoomDTO;
import com.example.desafio2.dtos.RoomAreaDTO;
import com.example.desafio2.services.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/houses")
@RestController
public class HouseController {
    @Autowired
    IHouseService iHouseService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void postHouse(@Valid @RequestBody HouseDTO house){
        iHouseService.add(house);
    }

    @GetMapping("/{houseId}/squaremeters")
    public double getTotalSquareMeters(@PathVariable int houseId){
        return iHouseService.getTotalSquareMeters(houseId);
    }

    @GetMapping("/{houseId}/price")
    public double getPrice(@PathVariable int houseId){
        return iHouseService.getPrice(houseId);
    }

    @GetMapping("/{houseId}/rooms/biggest")
    public ResponseEntity<RoomDTO> getBiggestRoom(@PathVariable int houseId){
        return new ResponseEntity<>(iHouseService.getBiggestRoom(houseId),HttpStatus.OK);
    }

    @GetMapping("/{houseId}/rooms/squaremeters")
    public ResponseEntity<List<RoomAreaDTO>> getSquareMetersPerRoom(@PathVariable int houseId){
        return new ResponseEntity<>(iHouseService.getRoomsAreas(houseId),HttpStatus.OK);
    }
}





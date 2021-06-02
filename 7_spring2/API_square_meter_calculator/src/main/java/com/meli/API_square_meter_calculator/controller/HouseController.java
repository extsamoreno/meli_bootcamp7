package com.meli.API_square_meter_calculator.controller;

import com.meli.API_square_meter_calculator.dto.HouseDTO;
import com.meli.API_square_meter_calculator.entities.Bedroom;
import com.meli.API_square_meter_calculator.entities.House;
import com.meli.API_square_meter_calculator.service.DataBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @GetMapping("/")
    public ResponseEntity<String> getMain(){
        String message = "Welcome to the API Houses";
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createHouse(@RequestBody House houseDTO) {
        DataBase.addHouse(new House(houseDTO.getName(), houseDTO.getAddress(), houseDTO.getBedrooms()));
        return new ResponseEntity<>("House Created",HttpStatus.CREATED);
    }

    @GetMapping("/square_meters/{id}")
    public ResponseEntity<String> returnTotalSizeHouseAt(@PathVariable int id) {
        return new ResponseEntity<>(DataBase.getTotalSquareMetersOfHouseAt(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/value/{id}")
    public ResponseEntity<String> returnValueOfHouseAt(@PathVariable int id) {
        return new ResponseEntity<>(DataBase.getHomeValue(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/max_bedrom/{id}")
    public ResponseEntity<Bedroom> returnMaxBedromOfHouseAt(@PathVariable int id) {
        return new ResponseEntity<>(DataBase.returnMaxBedroom(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/bedrooms_at/{id}")
    public ResponseEntity<HouseDTO> returnBedromsFromHouse(@PathVariable int id) {
        return new ResponseEntity<>(DataBase.getBetroomsFromHouse(id),HttpStatus.ACCEPTED);
    }
}

package com.example.tucasita.controller;

import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.HouseWithLargestRoom;
import com.example.tucasita.dto.response.HouseWithRoomsMetersDTO;
import com.example.tucasita.dto.response.HouseWithTotalMeters;
import com.example.tucasita.dto.response.HouseWithTotalValue;
import com.example.tucasita.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/house")
public class TuCasitaController {

    @Autowired
    IHouseService houseService;

    @PostMapping("/total-square-meters")
    public ResponseEntity<HouseWithTotalMeters> calculateTotalMeters(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateTotalMeters(houseDto), HttpStatus.OK);
    }

    @PostMapping("/total-value")
    public ResponseEntity<HouseWithTotalValue> calculateTotalValue(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateTotalValue(houseDto), HttpStatus.OK);
    }

    @PostMapping("/largest-room")
    public ResponseEntity<HouseWithLargestRoom> calculateLargestRoom(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateLargestRoom(houseDto), HttpStatus.OK);
    }

    @PostMapping("/rooms-square-meters")
    public ResponseEntity<HouseWithRoomsMetersDTO> calculateRoomsSquareMeters(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateRoomsSquareMeters(houseDto), HttpStatus.OK);
    }

}

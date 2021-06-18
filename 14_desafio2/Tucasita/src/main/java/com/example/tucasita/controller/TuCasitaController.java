package com.example.tucasita.controller;

import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.response.HouseWithLargestRoom;
import com.example.tucasita.dto.response.HouseWithRoomsMetersDTO;
import com.example.tucasita.dto.response.HouseWithTotalMeters;
import com.example.tucasita.dto.response.HouseWithTotalValue;
import com.example.tucasita.service.IHouseService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("Return the total square meters of a given house")
    public ResponseEntity<HouseWithTotalMeters> calculateTotalMeters(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateTotalMeters(houseDto), HttpStatus.OK);
    }

    @PostMapping("/total-value")
    @ApiOperation("Return the total value in U$S of a given house")
    public ResponseEntity<HouseWithTotalValue> calculateTotalValue(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateTotalValue(houseDto), HttpStatus.OK);
    }

    @PostMapping("/largest-room")
    @ApiOperation("Return the largest room of a given house")
    public ResponseEntity<HouseWithLargestRoom> calculateLargestRoom(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateLargestRoom(houseDto), HttpStatus.OK);
    }

    @PostMapping("/rooms-square-meters")
    @ApiOperation("Return the house with the square meters of the rooms of a given house")
    public ResponseEntity<HouseWithRoomsMetersDTO> calculateRoomsSquareMeters(@Valid @RequestBody HouseDTO houseDto) {
        return new ResponseEntity(houseService.calculateRoomsSquareMeters(houseDto), HttpStatus.OK);
    }

}

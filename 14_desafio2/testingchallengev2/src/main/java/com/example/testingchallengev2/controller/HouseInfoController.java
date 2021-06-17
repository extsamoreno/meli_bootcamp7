package com.example.testingchallengev2.controller;

import com.example.testingchallengev2.exception.DistrictNotFoundException;
import com.example.testingchallengev2.exception.HouseNotFoundException;
import com.example.testingchallengev2.model.response.*;
import com.example.testingchallengev2.service.IHouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/tucasita")
public class HouseInfoController {

    @Autowired
    IHouseInfoService iHouseInfoService;

    @GetMapping("/districts")
    public ResponseEntity<DistrictListResponseDTO> getDistrictList()
    {
        return new ResponseEntity<>(iHouseInfoService.getDistrictListDTO(), HttpStatus.OK);
    }

    @GetMapping("/houses")
    public ResponseEntity<HouseListResponseDTO> getHouseList()
    {
        return new ResponseEntity<>(iHouseInfoService.getHouseListDTO(), HttpStatus.OK);
    }

    @GetMapping("/totalArea/{houseName}")
    public ResponseEntity<TotalHouseAreaResponseDTO> getTotalHouseArea(@PathVariable String houseName) throws HouseNotFoundException {
        return new ResponseEntity<>(iHouseInfoService.getTotalHouseAreaResponseDTO(houseName), HttpStatus.OK);
    }

    @GetMapping("/price/{houseName}")
    public ResponseEntity<HouseValueResponseDTO> getHousePrice(@PathVariable String houseName) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(iHouseInfoService.getHouseValueResponseDTO(houseName), HttpStatus.OK);
    }

    @GetMapping("/biggestRoom/{houseName}")
    public ResponseEntity<HouseBiggestRoomResponseDTO> getBiggestRoom(@PathVariable String houseName) throws HouseNotFoundException {
        return new ResponseEntity<>(iHouseInfoService.getHouseBiggestRoomResponseDTO(houseName), HttpStatus.OK);
    }

    @GetMapping("/rooms/{houseName}")
    public ResponseEntity<RoomsSizeResponseDTO> getRoomsSize(@PathVariable String houseName) throws HouseNotFoundException {
        return new ResponseEntity<>(iHouseInfoService.getRoomsSizeResponseDTO(houseName), HttpStatus.OK);
    }
}

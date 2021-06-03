package com.example.Spring2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {

    //private HouseService hService = new HouseService();
    @Autowired
    private HouseService hService;

    @PostMapping("/calcM2")
    public ResponseEntity<ResponseHouseDTO> calculateHouseM2(@RequestBody House h) {
        return new ResponseEntity<>(hService.calculateM2House(h), HttpStatus.OK);
    }

    @PostMapping("/calcValue")
    public ResponseEntity<ResponseHouseDTO> calculateHouseValue(@RequestBody House h) {
        return new ResponseEntity<>(hService.calculateValue(h), HttpStatus.OK);
    }

    @PostMapping("/calcBiggestRoom")
    public ResponseEntity<ResponseHouseDTO> calculateBiggestRoom(@RequestBody House h){
        return new ResponseEntity<>(hService.getBiggestRoom(h), HttpStatus.OK);
    }

    @PostMapping("/calcRoomsM2")
    public ResponseEntity<ResponseHouseDTO> getRoomsM2(@RequestBody House h){
        return new ResponseEntity<>(hService.getRoomsM2(h), HttpStatus.OK);
    }
}

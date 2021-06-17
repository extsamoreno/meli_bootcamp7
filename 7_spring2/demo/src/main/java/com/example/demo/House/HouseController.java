package com.example.demo.House;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {
    private HouseService houseService = new HouseService();
    @PostMapping("/calculate")
    public ResponseEntity<HouseDTO> calculateM2(@RequestBody House house){
        HouseDTO houseDTO = new HouseDTO(houseService.calculateM2(house),houseService.calculatePrice(house),houseService.biggestRoom(house),
                houseService.roomM2(house));
        ResponseEntity<HouseDTO> doubleResponseEntity = new ResponseEntity<>(houseDTO,HttpStatus.OK);
        return doubleResponseEntity;
    }



}

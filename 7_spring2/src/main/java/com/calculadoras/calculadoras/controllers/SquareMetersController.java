package com.calculadoras.calculadoras.controllers;
import com.calculadoras.calculadoras.entity.House;
import com.calculadoras.calculadoras.helpers.HouseHelper;
import com.calculadoras.calculadoras.mapper.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/squaremeters")
public class SquareMetersController {

    @PostMapping("/totalmeters")
    public ResponseEntity<ResponseDTO> getTotalMeters(@RequestBody House house){
        return new ResponseEntity<>(
                 new ResponseDTO(HouseHelper.getTotalSquareMeters(house)) ,
                HttpStatus.OK);
    }

    @PostMapping("/housevalue")
    public ResponseEntity<Integer> getHouseValue(@RequestBody House house){
        return new ResponseEntity<>(HouseHelper.getTotalSquareMeters(house)*800,HttpStatus.OK);
    }

    @PostMapping("/broom")
    public ResponseEntity<ResponseDTO> getBiggerRoom(@RequestBody List<House> houseList){
        return new ResponseEntity<>(
                HouseHelper.getBiggerRoom(houseList),
                HttpStatus.OK);
    }

    @PostMapping("/metersroom")
    public ResponseEntity<ResponseDTO> metersRoom(@RequestBody House house){
        return new ResponseEntity<>(
                new ResponseDTO(HouseHelper.metersPerRoom(house)),
                HttpStatus.OK);
    }

}

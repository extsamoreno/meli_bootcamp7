package com.example.demo.Controllers;


import com.example.demo.Services.DTO.HouseDTO;
import com.example.demo.Services.House;
import com.example.demo.Services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    HouseService houseService;

    @PostMapping()
    public ResponseEntity<?> addHouse(@RequestBody House house){
        HouseDTO houseDTO = houseService.getHouseDTO(house);
        return new ResponseEntity<>(houseDTO, HttpStatus.OK);
    }

}

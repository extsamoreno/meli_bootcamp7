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

    @PostMapping("/calcular")
    public ResponseEntity<ResponseHouseDTO> calculateHouseM2(@RequestBody House h){
        return new ResponseEntity<>(hService.calculateM2House(h), HttpStatus.OK);
    }
}

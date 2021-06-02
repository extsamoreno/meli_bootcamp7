package com.ejercitacion.ejercitacion.house.controller;

import com.ejercitacion.ejercitacion.house.model.House;
import com.ejercitacion.ejercitacion.house.model.HouseResponse;
import com.ejercitacion.ejercitacion.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/data")
    public ResponseEntity<HouseResponse> calculateHouseData(@RequestBody House house) {
        return ResponseEntity.ok(houseService.calculateHouseData(house));
    }
}

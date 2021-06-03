package com.example.APIHouse.controller;

import com.example.APIHouse.repository.House;
import com.example.APIHouse.service.IHouseService;
import com.example.APIHouse.service.dto.HouseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    IHouseService iHouseService;

    @PostMapping("/info")
    public HouseResponseDTO getHouseInfo(@RequestBody House house){
        return iHouseService.getHouseInfo(house);
    }


}

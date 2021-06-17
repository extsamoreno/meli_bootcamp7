package com.bootcamp.desafio2.controller;

import com.bootcamp.desafio2.dto.request.HouseDTO;
import com.bootcamp.desafio2.dto.response.EnvironmentShortDTO;
import com.bootcamp.desafio2.dto.response.HouseFeaturesDTO;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseAlreadyExistsException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import com.bootcamp.desafio2.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/properties")
public class HouseController {

    @Autowired
    private IHouseService houseService;

    // US-0001, US-0002, US-0003
    @GetMapping("/features/{prop_name}")
    public ResponseEntity<HouseFeaturesDTO> calculateFeatures(@PathVariable String prop_name) throws HouseNotFoundException, DistrictNotFoundException {
        HouseFeaturesDTO houseFeaturesDTO = houseService.calculateFeatures(prop_name);
        return new ResponseEntity(houseFeaturesDTO, HttpStatus.OK);
    }

    // US-0004
    @GetMapping("/environments/{prop_name}")
    public ResponseEntity<?> showEnvironmentList(@PathVariable String prop_name) throws HouseNotFoundException {
        ArrayList<EnvironmentShortDTO> environmentList = houseService.generateEnvironmentList(prop_name);
        return new ResponseEntity(environmentList, HttpStatus.OK);
    }

    @PostMapping("/registerProperty")
    @ResponseStatus(HttpStatus.OK)
    public void registerProperty(@RequestBody @Valid HouseDTO houseDTO) throws HouseAlreadyExistsException, DistrictNotFoundException {
        houseService.addNewProperty(houseDTO);
    }

}

package com.meli.desafio.controllers;

import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.Room;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.models.dto.RoomResponseDTO;
import com.meli.desafio.services.ICalculateService;
import com.meli.desafio.utils.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private ICalculateService calculateService;

    @PostMapping
    public ResponseEntity<String> addHouse(@Valid @RequestBody HouseDTO houseDTO) throws HouseAlreadyExistsException {
        return new ResponseEntity<>(URLBuilder.buildURL("calculate/getHouse", calculateService.save(houseDTO), ""), HttpStatus.OK);
    }

    @GetMapping("/house/{id}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable Integer id) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(calculateService.getHouseById(id), HttpStatus.OK);
    }

    @GetMapping("/house/{id}/totalMeters")
    public ResponseEntity<String> getTotalMeters(@PathVariable Integer id) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>(calculateService.getTotalMeters(id) + "m2", HttpStatus.OK);
    }

    @GetMapping("/house/{id}/totalPrice")
    public ResponseEntity<String> getTotalPrice(@PathVariable Integer id) throws HouseNotFoundException, DistrictNotFoundException {
        return new ResponseEntity<>("U$D " + calculateService.getTotalPrice(id), HttpStatus.OK);
    }

    @GetMapping("/house/{id}/biggerRoom")
    public ResponseEntity<Room> getBiggerRoom(@PathVariable Integer id) throws HouseNotFoundException {
        return new ResponseEntity<>(calculateService.getBiggerRoom(id), HttpStatus.OK);
    }

    @GetMapping("/house/{id}/mettersByRoom")
    public ResponseEntity<List<RoomResponseDTO>> getmettersByRoom(@PathVariable Integer id) throws HouseNotFoundException {
        return new ResponseEntity<>(calculateService.getmetterByRoom(id), HttpStatus.OK);
    }
}

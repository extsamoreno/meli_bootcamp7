package com.springbootday2.springbootday2.controllers;

import com.springbootday2.springbootday2.dtos.HouseDTO;
import com.springbootday2.springbootday2.dtos.RoomDTO;
import com.springbootday2.springbootday2.services.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/houses")
public class HouseController {

    private HouseService houseService;

    public HouseController() {
        this.houseService = new HouseService();
    }

    @PostMapping
    public ResponseEntity<String> addHouse(@RequestBody HouseDTO houseDTO) {
        String result = this.houseService.addHouse(houseDTO);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/metersByHouse/{idHouse}")
    public ResponseEntity<HouseDTO> getMeterPow2ByHouse(@PathVariable int idHouse) {
        HouseDTO result = this.houseService.getMeterPow2ByHouse(idHouse);

        HttpStatus statusCode = Objects.isNull(result) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(result, statusCode);
    }

    @GetMapping("/price/{idHouse}")
    public ResponseEntity<Float> getPrice(@PathVariable int idHouse) {
        float result = this.houseService.getPrice(idHouse);

        HttpStatus statusCode = Objects.isNull(result) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(result, statusCode);
    }

    @GetMapping("/bigRoom/{idHouse}")
    public ResponseEntity<RoomDTO> getBigRoom(@PathVariable int idHouse) {
        RoomDTO roomDTO = this.houseService.getBigRoom(idHouse);

        HttpStatus statusCode = Objects.isNull(roomDTO) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(roomDTO, statusCode);
    }

    @GetMapping("/meterByRoom/{idHouse}")
    public ResponseEntity<RoomDTO[]> getMeterPow2ByRoom(@PathVariable int idHouse) {
        RoomDTO[] roomDTOS = this.houseService.getMeterPow2ByRoom(idHouse);

        HttpStatus statusCode = Objects.isNull(roomDTOS) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(roomDTOS, statusCode);
    }
}

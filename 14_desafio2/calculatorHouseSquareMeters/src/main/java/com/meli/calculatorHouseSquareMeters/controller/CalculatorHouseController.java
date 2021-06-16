package com.meli.calculatorHouseSquareMeters.controller;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseBiggestRoomResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRequestDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRoomListResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseTotalQuantityResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.exception.*;
import com.meli.calculatorHouseSquareMeters.model.service.ServiceCalculatorHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorHouseController {

    @Autowired
    private ServiceCalculatorHouse serviceCalculatorHouse;

    @PostMapping("/createHouse")
    public ResponseEntity<?> createNewHouse(@RequestBody HouseRequestDTO houseRequestDTO)
            throws DistrictNotFoundException, RepeatedHouseException, HouseNotCreatedException {
        serviceCalculatorHouse.createNewHouse(houseRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/createDistrict")
    public ResponseEntity<?> createNewDistrict(@RequestBody District district)
            throws RepeatedDistrictException, DistrictNotCreatedException {
        serviceCalculatorHouse.createNewDistrict(district);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/totalQuantity/{houseName}")
    public ResponseEntity<HouseTotalQuantityResponseDTO> getTotalQuantity(@PathVariable String houseName)
            throws HouseNotFoundException {
        return new ResponseEntity<>(serviceCalculatorHouse.getTotalQuantifyOfHouse(houseName), HttpStatus.OK);
    }

    @GetMapping("/biggestRoom/{houseName}")
    public ResponseEntity<HouseBiggestRoomResponseDTO> getBiggestRoom(@PathVariable String houseName)
            throws HouseNotFoundException {
        return new ResponseEntity<>(serviceCalculatorHouse.getHouseBiggestRoomOfHouse(houseName), HttpStatus.OK);
    }

    @GetMapping("/list/{houseName}")
    public ResponseEntity<HouseRoomListResponseDTO> getRoomList(@PathVariable String houseName)
            throws HouseNotFoundException {
        return new ResponseEntity<>(serviceCalculatorHouse.getHouseRoomListResponseDTO(houseName), HttpStatus.OK);
    }
}

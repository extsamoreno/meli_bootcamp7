package com.example.tuCasita.controllers;

import com.example.tuCasita.dtos.*;
import com.example.tuCasita.exceptions.*;
import com.example.tuCasita.models.Home;
import com.example.tuCasita.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private IHomeService homeService;

    @GetMapping("/getSquare/{homeId}")
    public ResponseEntity<Double> getSquareMeterByHome(@PathVariable Integer homeId) throws HomeIdNotFoundException {
        return new ResponseEntity<Double>(homeService.getSquareMeterByHome(homeId), HttpStatus.OK);
    }

    @GetMapping("/getPrice/{homeId}")
    public ResponseEntity<Double> getPrice(@PathVariable Integer homeId) throws HomeIdNotFoundException {
        return new ResponseEntity<Double>(homeService.getPrice(homeId), HttpStatus.OK);
    }

    @GetMapping("/getBiggest/{homeId}")
    public ResponseEntity<EnviromentDTO> getBiggestEnviroment(@PathVariable Integer homeId) throws HomeIdNotFoundException, HomeWithNoEnviromentsException {
        return new ResponseEntity<EnviromentDTO>(homeService.getBiggest(homeId), HttpStatus.OK);
    }

    @GetMapping("/getMeter/{homeId}")
    public ResponseEntity<List<EnviromentAreasDTO>> getMeterCount(@PathVariable Integer homeId) throws HomeIdNotFoundException {
        return new ResponseEntity<List<EnviromentAreasDTO> >(homeService.getMeterCount(homeId), HttpStatus.OK);
    }

    @PostMapping("/insertHome")
    public ResponseEntity<HomeResponseDTO> insertHome(@RequestBody @Valid HomeDTO homeDTO) throws AlreadyExistHomeException, AlreadyExistDistrictException, DistrictNotFoundException, AlreadyExistEnviromentIdException {
        return new ResponseEntity<HomeResponseDTO>(homeService.insertHome(homeDTO), HttpStatus.OK);
    }

    @PostMapping("/insertDistrict")
    public ResponseEntity<String> insertDistrict(@RequestBody @Valid DistrictDTO districtDTO) throws AlreadyExistDistrictException {
        return new ResponseEntity<String>(homeService.insertDistrict(districtDTO), HttpStatus.OK);
    }
}

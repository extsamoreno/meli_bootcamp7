package com.example.tuCasita.controllers;

import com.example.tuCasita.dtos.EnviromentDTO;
import com.example.tuCasita.dtos.HomeDTO;
import com.example.tuCasita.dtos.HomeResponseDTO;
import com.example.tuCasita.exceptions.AlreadyExistHomeException;
import com.example.tuCasita.exceptions.HomeIdNotFoundException;
import com.example.tuCasita.models.Home;
import com.example.tuCasita.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    private IHomeService homeService;

    @GetMapping("/getSquare/{homeId}")
    public ResponseEntity<Double> getSquareMeterByHome(@PathVariable Integer homeId){
        return new ResponseEntity<Double>(homeService.getSquareMeterByHome(homeId), HttpStatus.OK);
    }

    @GetMapping("/getPrice/{homeId}")
    public ResponseEntity<Double> getPrice(@PathVariable Integer homeId){
        return new ResponseEntity<Double>(homeService.getPrice(homeId), HttpStatus.OK);
    }

    @GetMapping("/getBiggest/{homeId}")
    public ResponseEntity<EnviromentDTO> getBiggestEnviroment(@PathVariable Integer homeId) throws HomeIdNotFoundException {
        return new ResponseEntity<EnviromentDTO>(homeService.getBiggest(homeId), HttpStatus.OK);
    }

    @GetMapping("/getMeter/{homeId}")
    public ResponseEntity<List<EnviromentDTO>> getMeterCount(@PathVariable Integer homeId) throws HomeIdNotFoundException {
        return new ResponseEntity<List<EnviromentDTO> >(homeService.getMeterCount(homeId), HttpStatus.OK);
    }

    @PostMapping("/insertHome")
    public ResponseEntity<HomeResponseDTO> insertHome(@RequestBody HomeDTO homeDTO) throws AlreadyExistHomeException {
        return new ResponseEntity<HomeResponseDTO>(homeService.insertHome(homeDTO), HttpStatus.OK);
    }
}

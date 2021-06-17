package com.meli.demo.controller;


import com.meli.demo.dto.EnvironmentDTO;
import com.meli.demo.dto.HouseDTO;
import com.meli.demo.dto.response.EnvironmentsTotalDTO;
import com.meli.demo.dto.response.PriceMetersResponseDTO;
import com.meli.demo.dto.response.TotalMetersResponseDTO;
import com.meli.demo.exepciones.HouseExistException;
import com.meli.demo.exepciones.HouseNotFoundException;
import com.meli.demo.exepciones.NeighborhoodNotFounException;
import com.meli.demo.exepciones.PriceIncorrectException;
import com.meli.demo.service.ITuCasitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/tucasita")
public class TuCasitaController {
    @Autowired
    ITuCasitaService iTuCasitaService;

    @PostMapping("/insertCasita")
    public ResponseEntity<Boolean> newCasita(@RequestBody @Valid HouseDTO houseDTO) throws PriceIncorrectException, NeighborhoodNotFounException, HouseExistException {
        return new ResponseEntity<>(iTuCasitaService.newCasita(houseDTO), HttpStatus.OK);
    }

    @GetMapping("/squareMeters/{nameHouse}")
    public ResponseEntity<TotalMetersResponseDTO> totalMeters(@PathVariable String nameHouse) throws HouseNotFoundException {
        return new ResponseEntity<>(iTuCasitaService.totalMeters(nameHouse), HttpStatus.OK);
    }

    @GetMapping("/metersPrice/{nameHouse}")
    public ResponseEntity<PriceMetersResponseDTO> priceMeters(@PathVariable String nameHouse) throws HouseNotFoundException {
        return new ResponseEntity<>(iTuCasitaService.priceMeters(nameHouse), HttpStatus.OK);
    }

    @GetMapping("/biggerEnvironment/{nameHouse}")
    public ResponseEntity<EnvironmentDTO> biggerEnvironment(@PathVariable String nameHouse) throws HouseNotFoundException {
        return new ResponseEntity<>(iTuCasitaService.biggerEnvironment(nameHouse), HttpStatus.OK);
    }

    @GetMapping("/squareMetersByEnvironment/{nameHouse}")
    public ResponseEntity<EnvironmentsTotalDTO> totalMetersByEnvironment(@PathVariable String nameHouse) throws HouseNotFoundException {
        return new ResponseEntity<>(iTuCasitaService.totalMetersByEnvironment(nameHouse), HttpStatus.OK);
    }

    @GetMapping("/viewHouse/{nameHouse}")
    public ResponseEntity<HouseDTO> viewHouse(@PathVariable String nameHouse) throws HouseNotFoundException {
        return new ResponseEntity<>(iTuCasitaService.viewHouse(nameHouse), HttpStatus.OK);
    }
    @GetMapping("/viewNeighborhoods")
    public ResponseEntity<HashMap<String, Double>> viewNeighborhoods() throws HouseNotFoundException {
        return new ResponseEntity<>(iTuCasitaService.viewNeighborhoods(), HttpStatus.OK);
    }

}

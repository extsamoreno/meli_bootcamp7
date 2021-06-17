package desafio2.testing.controller;

import desafio2.testing.domian.House;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.service.IHouseService;
import desafio2.testing.service.dto.HouseLargestEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPerEnvironmentDTO;
import desafio2.testing.service.dto.HouseMeterPropertyDTO;
import desafio2.testing.service.dto.HousePriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class CalculateController {

    @Autowired
    IHouseService houseService;

    @PostMapping("/newHouse")
    public ResponseEntity<?> newHouse(@RequestBody House house) throws NotFoundException, HouseExistException {
        houseService.newHouse(house);
        return new ResponseEntity<>("¡Exit!",HttpStatus.OK);
    }

    @GetMapping("/meterProperty/{id}")
    public ResponseEntity<HouseMeterPropertyDTO> meterProperty(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.meterProperty(id), HttpStatus.OK);
    }

    @GetMapping("/priceProperty/{id}")
    public ResponseEntity<HousePriceDTO> priceProperty(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.priceProperty(id), HttpStatus.OK);
    }

    @GetMapping("/largestEnvironmente/{id}")
    public ResponseEntity<HouseLargestEnvironmentDTO> largestEnvironmente(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.largestEnvironmente(id), HttpStatus.OK);
    }

    @GetMapping("/meterPerEnvironment/{id}")
    public ResponseEntity<HouseMeterPerEnvironmentDTO> meterPerEnvironment(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.meterPerEnvironment(id), HttpStatus.OK);
    }

}

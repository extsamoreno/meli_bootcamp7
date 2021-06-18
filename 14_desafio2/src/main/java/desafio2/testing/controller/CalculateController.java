package desafio2.testing.controller;

import desafio2.testing.exception.DistrictException;
import desafio2.testing.exception.HouseExistException;
import desafio2.testing.exception.NotFoundException;
import desafio2.testing.service.IHouseService;
import desafio2.testing.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/house")
public class CalculateController {

    @Autowired
    IHouseService houseService;

    /**
     * Allows to receive a house by parameter
     * @param houseDTO
     * @return
     * @throws NotFoundException
     * @throws HouseExistException
     * @throws DistrictException
     */
    @PostMapping("/newHouse")
    public ResponseEntity<String> newHouse(@Valid @RequestBody HouseDTO houseDTO) throws NotFoundException, HouseExistException, DistrictException {
        houseService.newHouse(houseDTO);
        return new ResponseEntity<>("¡Exit!",HttpStatus.OK);
    }


    /**
     * It allows to determine the total square meters of a property
     * @param id
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/meterProperty/{id}")
    public ResponseEntity<HouseMeterPropertyDTO> meterProperty(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.meterProperty(id), HttpStatus.OK);
    }

    /**
     * Indicate the value of a property based on its environments and measurements.
     * Please note that prices per square meter are determined by district
     * @param id
     * @return
     * @throws NotFoundException
     */

    @GetMapping("/priceProperty/{id}")
    public ResponseEntity<HousePriceDTO> priceProperty(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.priceProperty(id), HttpStatus.OK);
    }


    /**
     * It allows you to determine which is the largest environment of a property.
     * @param id
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/largestEnvironment/{id}")
    public ResponseEntity<HouseLargestEnvironmentDTO> largestEnvironment(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.largestEnvironment(id), HttpStatus.OK);
    }


    /**
     * It allows to determine the amount of square meters that each environment of a property has.
     * @param id
     * @return
     * @throws NotFoundException
     */
    @GetMapping("/meterPerEnvironment/{id}")
    public ResponseEntity<HouseMeterPerEnvironmentDTO> meterPerEnvironment(@PathVariable int id) throws NotFoundException {
        return new ResponseEntity<>(houseService.meterPerEnvironment(id), HttpStatus.OK);
    }

}

package SquareMeterCalculator;

import SquareMeterCalculator.Core.HouseCore;
import SquareMeterCalculator.Entity.House;
import SquareMeterCalculator.Mapper.HouseDTO;
import SquareMeterCalculator.Mapper.ResponseSquareMeterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Squaremetercalculator")
public class SquareMeterCalculatorController {
    @RequestMapping("/hello")
    public String hello() {
        return "meter";
    }

    @PostMapping("/create")
    public ResponseEntity<House> createhouse(@RequestBody House house){
//        House obj = new House(house.getName(),house.getAddress(),house.getRooms());

        return new ResponseEntity<>(new House(house.getName(),house.getAddress(),house.getRooms()),HttpStatus.CREATED);
    }
    @PostMapping("/squaremeterhouse")
    public ResponseEntity<ResponseSquareMeterDTO> squeareMeterHouse(@RequestBody House house){
        HouseCore core= new HouseCore();
        return new ResponseEntity<>(
                new ResponseSquareMeterDTO(String.valueOf(core.getSqueareMeter(house)),HttpStatus.OK),
                HttpStatus.OK);
    }
    @PostMapping("/houseprice")
    public ResponseEntity<ResponseSquareMeterDTO> housePrice(@RequestBody House house){
        HouseCore core= new HouseCore();
        return new ResponseEntity<>(
                new ResponseSquareMeterDTO(String.valueOf(core.getHousePrice(house)),HttpStatus.OK),
                HttpStatus.OK);
    }
    @PostMapping("/biggerroom")
    public ResponseEntity<ResponseSquareMeterDTO> biggerRoom(@RequestBody House house){
        HouseCore core= new HouseCore();
        return new ResponseEntity<>(
                new ResponseSquareMeterDTO(core.getBiggetRoom(house),HttpStatus.OK),
                HttpStatus.OK);
    }
    @PostMapping("/squearemeterrooms")
    public ResponseEntity<ResponseSquareMeterDTO> squareMeterRooms(@RequestBody House house){
        HouseCore core= new HouseCore();
        return new ResponseEntity<>(
                new ResponseSquareMeterDTO(core.getSquareMeterRooms(house),HttpStatus.OK),
                HttpStatus.OK);
    }





}

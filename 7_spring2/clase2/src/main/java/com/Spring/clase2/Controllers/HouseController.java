package com.Spring.clase2.Controllers;

import com.Spring.clase2.Entities.House;
import com.Spring.clase2.Entities.Room;
import com.Spring.clase2.Services.HouseService;
import com.Spring.clase2.Entities.ResponseHouseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {

    private HouseService hService = new HouseService();
    //a
    @PostMapping("/calculateM2")
    public ResponseEntity<ResponseHouseDTO> calculateM2(@RequestBody House house){
        ResponseHouseDTO resp = new ResponseHouseDTO();
        resp.setHouse(house);
        resp.setM2(hService.calculateM2(house));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    //b
    @PostMapping("/calculatePrice/{priceM2}")
    public ResponseEntity<ResponseHouseDTO> calculatePrice(@PathVariable() double priceM2, @RequestBody House house){
        ResponseHouseDTO resp = new ResponseHouseDTO();
        resp.setHouse(house);
        resp.setPrice(hService.calculatePrice(house, priceM2));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/roomBiggest/")
    public ResponseEntity<Room> roomBiggest(@RequestBody House house){
        return new ResponseEntity<>(hService.roomBiggest(house), HttpStatus.OK);
    }

    //d
    @PostMapping("/m2byRoom/")
    public ResponseEntity<ResponseHouseDTO> m2byRoom(@RequestBody House house){
        ResponseHouseDTO resp = new ResponseHouseDTO();
        resp.setHouse(hService.m2byRoom(house));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}

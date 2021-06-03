package com.spring2.ejercicios.casa;

import com.spring2.ejercicios.casa.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Hashtable;

@RestController
@RequestMapping("/house")
public class HouseController {

    @PostMapping("/datahouse")
    public ResponseEntity<ResponseDTO> getDataHouse(@RequestBody ModelHouse dataHouse){
        ModelHouse house = new ModelHouse();

        // Extract Data
        house.setName(dataHouse.getName());
        house.setAddress(dataHouse.getAddress());
        house.setRooms(dataHouse.getRooms());

        // Total Area House
        TotalAreaDTO ta = new TotalAreaDTO(house.houseArea());

        // House Price
        PriceDTO pr = new PriceDTO(house.housePrice());

        // Bigger Room
        BiggerRoomDTO br = new BiggerRoomDTO(house);

        // Rooms
        RoomsDTO ra = new RoomsDTO(house.getRooms());

        ResponseDTO respuestaCompleta = new ResponseDTO(ta, pr, br, ra);
        return new ResponseEntity<>(respuestaCompleta,HttpStatus.OK);
    }

}

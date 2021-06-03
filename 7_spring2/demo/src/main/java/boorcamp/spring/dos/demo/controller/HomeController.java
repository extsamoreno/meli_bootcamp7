package boorcamp.spring.dos.demo.controller;


import boorcamp.spring.dos.demo.dto.MetrosDTO;
import boorcamp.spring.dos.demo.dto.MoneyDTO;
import boorcamp.spring.dos.demo.dto.RoomDTO;
import boorcamp.spring.dos.demo.entidades.Home;
import boorcamp.spring.dos.demo.entidades.Room;
import boorcamp.spring.dos.demo.services.HomeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeServices homeServices;

    @PostMapping("/metros")
    public ResponseEntity<MetrosDTO> getMetrosCuadradosCasa(@RequestBody Home home){
        return new ResponseEntity<>(homeServices.getAreaHome(home), HttpStatus.OK);
    }


    @PostMapping("/valor")
    public ResponseEntity<MoneyDTO> getValorCasa(@RequestBody Home home){
        return new ResponseEntity<>(homeServices.getPrecioHome(home), HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<List<RoomDTO>> getRooms(@RequestBody Home home){
        return new ResponseEntity<>(homeServices.getRoomsWithArea(home), HttpStatus.OK);
    }

    @PostMapping("/room-max")
    public ResponseEntity<Room> getmaxRoom(@RequestBody Home home){
        return new ResponseEntity<>(homeServices.getMaxRooms(home), HttpStatus.OK);
    }
}

package ej1;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @PostMapping("/calculateSquareMeters")
    public ResponseEntity<Float> createUser(@RequestBody House house){
        return new ResponseEntity<>(house.calculateSquareMeters(),HttpStatus.OK);
    }

    @PostMapping("/calculateValue")
    public ResponseEntity<Float> calculateValue(@RequestBody House house){
        return new ResponseEntity<>(house.calculateValue(),HttpStatus.OK);
    }

    @PostMapping("/biggestRoom")
    public ResponseEntity<RoomDTO> getBiggestRoom(@RequestBody House house){
        Room room = house.getBiggestRoom();
        return new ResponseEntity<>(new RoomDTO(room.getName(), room.getWidth(), room.getLength()),HttpStatus.OK);
    }

    @PostMapping("/roomsSize")
    public ResponseEntity<List<RoomM2DTO>> getRoomsSize(@RequestBody House house){
        return new ResponseEntity<List<RoomM2DTO>>(house.roomsSizeDTO(),HttpStatus.OK);
    }
}

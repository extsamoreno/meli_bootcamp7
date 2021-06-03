package com.spring2.spring2.Controllers;

import com.spring2.spring2.Classes.House;
import com.spring2.spring2.Classes.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/house")
public class HouseController {

        private HashMap<String, House> houseMap = new HashMap<>();

        @PostMapping("/create")
        public ResponseEntity<House> createHouse(@RequestBody House houseDTO){
                House h = houseMap.put(houseDTO.getName(),houseDTO);

                return new ResponseEntity(new House(houseDTO.getName(), houseDTO.getAddress()), HttpStatus.CREATED);
        }

        @PostMapping("/{houseName}/addRoom")
        public ResponseEntity<Room> addRoom (@PathVariable String houseName,
                                             @RequestParam String roomName,
                                             @RequestParam double wide,
                                             @RequestParam double large) {
                House h = houseMap.get(houseName);
                Room r = new Room(roomName, wide, large);
                h.addRoom(r);

                return new ResponseEntity(r,HttpStatus.CREATED);
        }

        @GetMapping("/{houseName}/squareMeters")
        public ResponseEntity<Double> getSquareMeters(@PathVariable String houseName) {
                House h = houseMap.get(houseName);
                double meters = h.getTotalSquareMeters();

                return new ResponseEntity(meters, HttpStatus.OK);
        }

        @GetMapping("/price/{houseName}")
        public ResponseEntity<Double> getPrice(@PathVariable String houseName) {
                House h = houseMap.get(houseName);
                double price = h.getTotalSquareMeters() * 800;

                return new ResponseEntity<>(price, HttpStatus.OK);
        }

        @GetMapping("/biggestRoom")
        public ResponseEntity<Room> getBiggestRoom() {
                double max = 0;
                Room maxRoom = new Room();
                for (Map.Entry<String, House> entry : houseMap.entrySet()) {
                        List<Room> roomsList;
                        roomsList = entry.getValue().getRooms();
                        for (Room  r: roomsList) {
                                if (r.getSize() > max) {
                                        max = r.getSize();
                                        maxRoom = r;
                                }
                        }
                }

                return new ResponseEntity<>(maxRoom, HttpStatus.OK);
        }

        @GetMapping("/{houseName}/{roomName}")
        public ResponseEntity<Double> getRoomSquareMeters(@PathVariable String houseName,
                                                          @PathVariable String roomName) {
                House h = houseMap.get(houseName);
                Room r = h.getRooms().stream().filter(room -> roomName.equals(room.getName())).findAny().orElse(null);
                double meters = 0;
                meters += r.getSize();

                return new ResponseEntity<>(meters, HttpStatus.OK);
        }


}

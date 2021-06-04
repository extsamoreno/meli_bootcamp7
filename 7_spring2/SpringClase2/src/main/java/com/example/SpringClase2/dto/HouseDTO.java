package com.example.springclase2.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static com.example.springclase2.services.HouseServices.findBiggestRoom;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDTO {

        private String houseName;
        private Double Area;
        private Double Price;
        private Room biggestRoom;
        private ArrayList<RoomDTO> roomsDTO = new ArrayList<>();

        public HouseDTO(House house)
        {
                setHouseName(house.getHouseName());
                setArea(house.getArea());
                setPrice(house.getPrice());
                setBiggestRoom(findBiggestRoom(house));
                //setRoomsDTO();
        }




}

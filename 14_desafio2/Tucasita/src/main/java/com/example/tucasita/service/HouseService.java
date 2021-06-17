package com.example.tucasita.service;

import com.example.tucasita.domain.District;
import com.example.tucasita.domain.House;
import com.example.tucasita.domain.Room;
import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.RoomDTO;
import com.example.tucasita.dto.response.*;
import com.example.tucasita.exception.NotFoundException;
import com.example.tucasita.repository.IDistrictRepository;
import com.example.tucasita.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService implements IHouseService {

    @Autowired
    IHouseRepository houseRepository;
    @Autowired
    IDistrictRepository districtRepository;


    @Override
    public HouseWithTotalMeters calculateTotalMeters(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithMeters(house);
    }

    @Override
    public HouseWithTotalValue calculateTotalValue(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithTotalValue(house);
    }

    @Override
    public HouseWithLargestRoom calculateLargestRoom(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithLargestRoom(house);
    }

    @Override
    public HouseWithRoomsMetersDTO calculateRoomsSquareMeters(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithRoomsMetersDTO(house);
    }

    private House getHouseFromDTO(HouseDTO houseDTO) {
        District district = searchDistrictByName(houseDTO.getDistrict().getName());
        List<Room> rooms = getRoomsFromDTO(houseDTO.getRooms());
        return new House(houseDTO.getName(), district, rooms);
    }

    private List<Room> getRoomsFromDTO(List<RoomDTO> rooms) {
        return rooms.stream().map(this::getRoomFromDTO).collect(Collectors.toList());
    }

    private Room getRoomFromDTO(RoomDTO r) {
        return new Room(r.getName(), r.getWidth(), r.getLength());
    }

    private District searchDistrictByName(String name) {
        return districtRepository.findByName(name).orElseThrow(() -> new NotFoundException("District"));
    }

    private HouseWithTotalMeters toHouseWithMeters(House house) {
        return new HouseWithTotalMeters(house.getName(), house.getTotalMeters());
    }

    private HouseWithTotalValue toHouseWithTotalValue(House house) {
        return new HouseWithTotalValue(house.getName(), house.getTotalValue());
    }

    private HouseWithLargestRoom toHouseWithLargestRoom(House house) {
        RoomWithMetersDTO roomDTO = getRoomWithMeterDTO(house.getLargestRoom());
        return new HouseWithLargestRoom(house.getName(), roomDTO);
    }

    private HouseWithRoomsMetersDTO toHouseWithRoomsMetersDTO(House house) {
        List<RoomWithMetersDTO> roomsDTO = this.getRoomsWithMetersDTO(house.getRooms());
        return new HouseWithRoomsMetersDTO(house.getName(), roomsDTO);
    }

    private List<RoomWithMetersDTO> getRoomsWithMetersDTO(List<Room> rooms) {
        return rooms.stream().map(this::getRoomWithMeterDTO).collect(Collectors.toList());
    }

    private RoomWithMetersDTO getRoomWithMeterDTO(Room room) {
        return new RoomWithMetersDTO(room.getName(), room.squareMeters());
    }
}

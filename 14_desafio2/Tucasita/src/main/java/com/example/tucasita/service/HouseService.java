package com.example.tucasita.service;

import com.example.tucasita.domain.District;
import com.example.tucasita.domain.House;
import com.example.tucasita.domain.Room;
import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.HouseDTO;
import com.example.tucasita.dto.RoomDTO;
import com.example.tucasita.dto.response.*;
import com.example.tucasita.exception.NotFoundException;
import com.example.tucasita.exception.PriceNotMatchException;
import com.example.tucasita.repository.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService implements IHouseService {

    @Autowired
    IDistrictRepository districtRepository;

    /**
     * returns a HouseWithTotalMeters of given a HouseDTO
     *
     * @param houseDTO
     * @return
     */
    @Override
    public HouseWithTotalMeters calculateTotalMeters(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithMeters(house);
    }

    /**
     * returns a HouseWithTotalValue of given a HouseDTO
     *
     * @param houseDTO
     * @return
     */
    @Override
    public HouseWithTotalValue calculateTotalValue(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithTotalValue(house);
    }

    /**
     * returns a HouseWithLargestRoom of given a HouseDTO
     *
     * @param houseDTO
     * @return
     */
    @Override
    public HouseWithLargestRoom calculateLargestRoom(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithLargestRoom(house);
    }

    /**
     * returns a HouseWithRoomsMetersDTO of given a HouseDTO
     *
     * @param houseDTO
     * @return
     */
    @Override
    public HouseWithRoomsMetersDTO calculateRoomsSquareMeters(HouseDTO houseDTO) {
        House house = this.getHouseFromDTO(houseDTO);
        return this.toHouseWithRoomsMetersDTO(house);
    }

    /**
     * ------------------------------
     * AUXILIARY FUNCTIONS
     * ------------------------------
     */

    /**
     * converts form HouseDTO to House
     *
     * @param houseDTO
     * @return
     */
    private House getHouseFromDTO(HouseDTO houseDTO) {
        District district = searchDistrict(houseDTO.getDistrict());
        List<Room> rooms = getRoomsFromDTO(houseDTO.getRooms());
        return new House(houseDTO.getName(), district, rooms);
    }

    /**
     * converts form a List<RoomDTO> to a List<Room>
     *
     * @param rooms
     * @return
     */
    private List<Room> getRoomsFromDTO(List<RoomDTO> rooms) {
        return rooms.stream().map(this::getRoomFromDTO).collect(Collectors.toList());
    }

    /**
     * converts from a RoomDTO to a Room
     *
     * @param r
     * @return
     */
    private Room getRoomFromDTO(RoomDTO r) {
        return new Room(r.getName(), r.getWidth(), r.getLength());
    }

    /**
     * find (if exists) a district in repository, and validates that the price is the same as the received
     *
     * @param district
     * @return
     */
    private District searchDistrict(DistrictDTO district) {
        District repoDistrict = districtRepository.findByName(district.getName()).orElseThrow(() -> new NotFoundException("District"));
        if (repoDistrict.getPrice() != district.getPrice()) throw new PriceNotMatchException();
        return repoDistrict;
    }

    /**
     * converts from a House to a HouseWithTotalMeters
     *
     * @param house
     * @return
     */
    private HouseWithTotalMeters toHouseWithMeters(House house) {
        return new HouseWithTotalMeters(house.getName(), house.getTotalMeters());
    }

    /**
     * converts from a House to a HouseWithTotalValue
     *
     * @param house
     * @return
     */
    private HouseWithTotalValue toHouseWithTotalValue(House house) {
        return new HouseWithTotalValue(house.getName(), house.getTotalValue());
    }

    /**
     * converts from a House to a HouseWithLargestRoom
     *
     * @param house
     * @return
     */
    private HouseWithLargestRoom toHouseWithLargestRoom(House house) {
        RoomWithMetersDTO roomDTO = getRoomWithMeterDTO(house.getLargestRoom());
        return new HouseWithLargestRoom(house.getName(), roomDTO);
    }

    /**
     * converts from a House to a HouseWithRoomsMetersDTO
     *
     * @param house
     * @return
     */
    private HouseWithRoomsMetersDTO toHouseWithRoomsMetersDTO(House house) {
        List<RoomWithMetersDTO> roomsDTO = this.getRoomsWithMetersDTO(house.getRooms());
        return new HouseWithRoomsMetersDTO(house.getName(), roomsDTO);
    }

    /**
     * converts from a List<Room> to a List<RoomWithMetersDTO>
     *
     * @param rooms
     * @return
     */
    private List<RoomWithMetersDTO> getRoomsWithMetersDTO(List<Room> rooms) {
        return rooms.stream().map(this::getRoomWithMeterDTO).collect(Collectors.toList());
    }

    /**
     * converts from a Room to a RoomWithMetersDTO
     *
     * @param room
     * @return
     */
    private RoomWithMetersDTO getRoomWithMeterDTO(Room room) {
        return new RoomWithMetersDTO(room.getName(), room.squareMeters());
    }
}

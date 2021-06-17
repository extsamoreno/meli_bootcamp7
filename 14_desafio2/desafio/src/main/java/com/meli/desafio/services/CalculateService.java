package com.meli.desafio.services;

import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.District;
import com.meli.desafio.models.House;
import com.meli.desafio.models.Room;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.repositories.ICalculateRepository;
import com.meli.desafio.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateService implements ICalculateService{

    @Autowired
    private ICalculateRepository calculateRepository;

    @Override
    public Integer save(HouseDTO houseDTO) throws HouseAlreadyExistsException {
        return calculateRepository.save(houseDTO);
    }

    @Override
    public HouseDTO getHouseById(Integer id) throws HouseNotFoundException, DistrictNotFoundException {
        House house = calculateRepository.getById(id);
        District district = calculateRepository.getDistrict(house.getDistrictId());
        return Mappers.houseToDTO(house, Mappers.districtToDTO(district));
    }

    @Override
    public Double getTotalMeters(Integer id) throws HouseNotFoundException, DistrictNotFoundException {
        HouseDTO house = this.getHouseById(id);
        return calculateTotalMeters(house.getRooms());
    }

    @Override
    public Double getTotalPrice(Integer id) throws HouseNotFoundException, DistrictNotFoundException {
        House house = calculateRepository.getById(id);
        District district = calculateRepository.getDistrict(house.getDistrictId());
        return calculateTotalPrice(house.getRooms(), district.getPrice());
    }

    @Override
    public Room getBiggerRoom(Integer id) throws HouseNotFoundException {
        List<Room> rooms = calculateRepository.getById(id).getRooms();
        return biggerRoom(rooms);
    }

    private Room biggerRoom(List<Room> rooms) {
        Room biggerRoom = new Room();
        double meters = 0;

        for(Room r: rooms){
            double meterRoom = this.calculateSquareMeters(r);
            if(meterRoom > meters){
                meters = meterRoom;
                biggerRoom = r;
            }
        }
        return biggerRoom;
    }

    private Double calculateTotalPrice(List<Room> rooms, double price) {
        return calculateTotalMeters(rooms) * price;
    }

    public double calculateTotalMeters(List<Room> rooms){
        return rooms.stream().mapToDouble(this::calculateSquareMeters).sum();
    }

    public double calculateSquareMeters(Room room) {
        return room.getWidth() * room.getLength();
    }
}

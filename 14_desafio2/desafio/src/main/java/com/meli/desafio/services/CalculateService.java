package com.meli.desafio.services;

import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import com.meli.desafio.models.Room;
import com.meli.desafio.models.dto.HouseDTO;
import com.meli.desafio.repositories.ICalculateRepository;
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
    public HouseDTO getHouseById(Integer id) throws HouseNotFoundException {
        return calculateRepository.getById(id);
    }

    @Override
    public Double getTotalMeters(Integer id) throws HouseNotFoundException {
        HouseDTO house = this.getHouseById(id);
        return calculateTotalMeters(house.getRooms());
    }

    public double calculateTotalMeters(List<Room> rooms){
        return rooms.stream().mapToDouble(r -> calculateSquareMeters(r)).sum();
    }

    private double calculateSquareMeters(Room room) {
        return room.getWidth() * room.getLength();
    }
}

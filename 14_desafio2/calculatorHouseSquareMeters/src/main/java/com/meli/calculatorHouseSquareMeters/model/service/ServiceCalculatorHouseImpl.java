package com.meli.calculatorHouseSquareMeters.model.service;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dao.model.House;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryDistrict;
import com.meli.calculatorHouseSquareMeters.model.dao.repository.RepositoryHouse;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseBiggestRoomResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRequestDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRoomListResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseTotalQuantityResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.exception.*;
import com.meli.calculatorHouseSquareMeters.model.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCalculatorHouseImpl implements ServiceCalculatorHouse {

    @Autowired
    private RepositoryHouse repositoryHouse;

    @Autowired
    private RepositoryDistrict repositoryDistrict;

    public void createNewHouse(HouseRequestDTO houseRequestDTO)
            throws DistrictNotFoundException, RepeatedHouseException, HouseNotCreatedException {

        District districtInRepository = repositoryDistrict.getDistrictByName(houseRequestDTO.getDistrictName());
        House houseInRepository = repositoryHouse.getHouseByName(houseRequestDTO.getHouseName());

        if (districtInRepository == null) {
            throw new DistrictNotFoundException(houseRequestDTO.getDistrictName());
        }
        if (houseInRepository != null) {
            throw new RepeatedHouseException(houseRequestDTO.getHouseName());
        }

        boolean isCreate = repositoryHouse.putHouse(HouseMapper.toHouseModel(houseRequestDTO, districtInRepository));

        if (!isCreate) {
            throw new HouseNotCreatedException(houseRequestDTO.getHouseName());
        }

    }

    public void createNewDistrict(District district) throws RepeatedDistrictException, DistrictNotCreatedException {
        District districtInRepository = repositoryDistrict.getDistrictByName(district.getDistrictName());
        if (districtInRepository != null) {
            throw new RepeatedDistrictException(district.getDistrictName());
        }

        boolean isCreate = repositoryDistrict.putDistrict(district);

        if (!isCreate) {
            throw new DistrictNotCreatedException(district.getDistrictName());
        }
    }

    public HouseTotalQuantityResponseDTO getTotalQuantifyOfHouse(String houseName) throws HouseNotFoundException {
       House house = repositoryHouse.getHouseByName(houseName);
       if (house == null) {
           throw new HouseNotFoundException(houseName);
       }
       return HouseMapper.toHouseTotalQuantityResponseDTO(house);
    }

    public HouseBiggestRoomResponseDTO getHouseBiggestRoomOfHouse(String houseName) throws HouseNotFoundException {
        House house = repositoryHouse.getHouseByName(houseName);
        if (house == null) {
            throw new HouseNotFoundException(houseName);
        }
        return HouseMapper.toHouseBiggestRoomResponseDTO(house);
    }

    public HouseRoomListResponseDTO getHouseRoomListResponseDTO (String houseName) throws HouseNotFoundException {
        House house = repositoryHouse.getHouseByName(houseName);
        if (house == null) {
            throw new HouseNotFoundException(houseName);
        }
        return HouseMapper.toHouseRoomListResponseDTO(house);
    }
}

package com.meli.calculatorHouseSquareMeters.model.service;

import com.meli.calculatorHouseSquareMeters.model.dao.model.District;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseBiggestRoomResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRequestDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseRoomListResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.dto.HouseTotalQuantityResponseDTO;
import com.meli.calculatorHouseSquareMeters.model.exception.*;

public interface ServiceCalculatorHouse {
    void createNewHouse(HouseRequestDTO houseRequestDTO)
            throws DistrictNotFoundException, RepeatedHouseException, HouseNotCreatedException;
    void createNewDistrict(District district) throws RepeatedDistrictException, DistrictNotCreatedException;
    HouseTotalQuantityResponseDTO getTotalQuantifyOfHouse(String houseName) throws HouseNotFoundException;
    HouseBiggestRoomResponseDTO getHouseBiggestRoomOfHouse(String houseName) throws HouseNotFoundException;
    HouseRoomListResponseDTO getHouseRoomListResponseDTO (String houseName) throws HouseNotFoundException;
}

package com.example.testingchallengev2.service;

import com.example.testingchallengev2.model.request.DistrictDTO;
import com.example.testingchallengev2.model.request.HouseDTO;
import com.example.testingchallengev2.model.response.DistrictCreatedResponseDTO;
import com.example.testingchallengev2.model.response.DistrictUpdatedResponseDTO;
import com.example.testingchallengev2.model.response.NewHouseResponseDTO;

public interface IAdminService {
    DistrictCreatedResponseDTO newDistrict(DistrictDTO districtDTO);

    DistrictUpdatedResponseDTO updateDistrict(DistrictDTO districtDTO);

    NewHouseResponseDTO createHouse(HouseDTO houseDTO);
}

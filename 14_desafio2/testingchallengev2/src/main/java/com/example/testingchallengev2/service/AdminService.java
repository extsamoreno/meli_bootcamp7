package com.example.testingchallengev2.service;

import com.example.testingchallengev2.model.request.DistrictDTO;
import com.example.testingchallengev2.model.request.HouseDTO;
import com.example.testingchallengev2.model.response.DistrictCreatedResponseDTO;
import com.example.testingchallengev2.model.response.DistrictUpdatedResponseDTO;
import com.example.testingchallengev2.model.response.NewHouseResponseDTO;
import com.example.testingchallengev2.repository.district.IDistrictRepository;
import com.example.testingchallengev2.repository.house.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{

    @Autowired
    IDistrictRepository iDistrictRepository;

    @Autowired
    IHouseRepository iHouseRepository;

    @Override
    public DistrictCreatedResponseDTO newDistrict(DistrictDTO districtDTO) {
        String message = "Can't create district. May be already exist.";
        if(iDistrictRepository.createDistrict(
                districtDTO.getName(), districtDTO.getPrice()))
        {
            message = "District created successfully.";
        }
        return new DistrictCreatedResponseDTO(districtDTO.getName(), message);
    }

    @Override
    public DistrictUpdatedResponseDTO updateDistrict(DistrictDTO districtDTO) {
        String message = "Can't update district. May be it doesn't exist.";
        if(iDistrictRepository.updateDistrict(districtDTO.getName(), districtDTO.getPrice()))
        {
            message = "District updated successfully.";
        }
        return new DistrictUpdatedResponseDTO(districtDTO.getName(), message);
    }

    @Override
    public NewHouseResponseDTO createHouse(HouseDTO houseDTO) {
        String result = "Can't create house. May be already exist.";
        if(iHouseRepository.createHouse(houseDTO))
        {
            result = "House created successfully.";
        }
        return new NewHouseResponseDTO(houseDTO.getName(), result, houseDTO);
    }
}

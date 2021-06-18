package com.meli.desafio.services;

import com.meli.desafio.exceptions.models.DistrictAlreadyExists;
import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.models.dto.DistrictDTO;
import com.meli.desafio.models.dto.DistrictRequestDTO;
import com.meli.desafio.repositories.ICalculateRepository;
import com.meli.desafio.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrictService{

    @Autowired
    private ICalculateRepository districtRepository;

    @Override
    public Integer saveDistrict(DistrictRequestDTO district) throws DistrictAlreadyExists {
        return districtRepository.saveDistrict(district);
    }

    @Override
    public DistrictDTO getById(Integer id) throws DistrictNotFoundException {
        return Mappers.districtToDTO(districtRepository.getDistrict(id));
    }
}

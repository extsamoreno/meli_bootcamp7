package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.DistrictDTO;
import com.meli.desafio2.web.exception.DistrictAlreadyExistException;
import com.meli.desafio2.web.repository.IDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DistrictService implements IDistrictService {
    @Autowired
    IDistrictRepository iDistrictRepository;
    @Override
    public DistrictDTO getDistrictByName(String name){
        return DistrictMapper.toDTO(iDistrictRepository.getDistrictByName(name));
    }

    @Override
    public void save(DistrictDTO districtDTO) throws DistrictAlreadyExistException {
        if(iDistrictRepository.getDistrictByName(districtDTO.getDistrict_name()) != null){
            throw new DistrictAlreadyExistException(districtDTO.getDistrict_name(), HttpStatus.BAD_REQUEST);
        }
        iDistrictRepository.saveDistrict(DistrictMapper.toModel(districtDTO));
    }

}

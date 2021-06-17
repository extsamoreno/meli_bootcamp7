package com.example.tucasita.service;

import com.example.tucasita.model.DistrictDTO;
import com.example.tucasita.model.ResponseDTO;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DistrictServiceImple implements DistrictService{

    @Autowired
    DistrictDAO districtDAO;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public ResponseDTO addOneDistrict(DistrictDTO district) {
        districtDAO.create(district);

        ResponseDTO response = new ResponseDTO(201, "El barrio se ha agregado con éxito al repositorio local");

        return response;
    }

    @Override
    public Set<DistrictDTO> getAllDistricts() {
        return this.districtRepository.findAll();
    }
}

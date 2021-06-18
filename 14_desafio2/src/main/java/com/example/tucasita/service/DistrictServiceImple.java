package com.example.tucasita.service;

import com.example.tucasita.dto.DistrictDTO;
import com.example.tucasita.dto.ResponseDTO;
import com.example.tucasita.model.District;
import com.example.tucasita.repository.DistrictDAO;
import com.example.tucasita.repository.DistrictRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImple implements DistrictService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DistrictDAO districtDAO;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public ResponseDTO addOneDistrict(DistrictDTO districtDTO) {
        District district = modelMapper.map(districtDTO, District.class);
        districtDAO.create(district);

        ResponseDTO response = new ResponseDTO(201, "El barrio se ha agregado con éxito al repositorio local");

        return response;
    }

}

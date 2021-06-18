package com.meli.tu_casita.service;

import com.meli.tu_casita.exception.DistrictAlreadyExistsException;
import com.meli.tu_casita.model.District;
import com.meli.tu_casita.repository.IDistrictDAO;
import com.meli.tu_casita.model.dto.DistrictDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    IDistrictDAO districtDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDistrict(DistrictDTO districtDTO) {
        Optional<District> district = districtDAO.findByName(districtDTO.getName());
        if (district.isEmpty()) {
            district = Optional.of(modelMapper.map(districtDTO, District.class));
            districtDAO.save(district.get());
        } else {
            throw new DistrictAlreadyExistsException(districtDTO.getName());
        }
    }

    @Override
    public List<DistrictDTO> getDistrictList() {
        List<District> districts = districtDAO.getDistrictList();
        List<DistrictDTO> districtDTOList = new ArrayList<>();
        for (District district : districts ) {
            districtDTOList.add(modelMapper.map(district, DistrictDTO.class));
        }
        return districtDTOList;
    }

}

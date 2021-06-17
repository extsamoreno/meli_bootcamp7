package com.meli.tu_casita.service;

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
    IDistrictDAO suburbDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDistrict(DistrictDTO districtDTO) {
        Optional<District> district = suburbDAO.findByName(districtDTO.getName());
        if (district.isEmpty()) {
            district = Optional.of(modelMapper.map(districtDTO, District.class));
            suburbDAO.save(district.get());
        }
    }

    @Override
    public List<DistrictDTO> getDistrictList() {
        List<District> districts = suburbDAO.getDistrictList();
        List<DistrictDTO> districtDTOList = new ArrayList<>();
        for (District district : districts ) {
            districtDTOList.add(modelMapper.map(district, DistrictDTO.class));
        }
        return districtDTOList;
    }

}

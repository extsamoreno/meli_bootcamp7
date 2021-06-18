package com.meli.tu_casita.service;

import com.meli.tu_casita.exception.DistrictAlreadyExistsException;
import com.meli.tu_casita.model.District;
import com.meli.tu_casita.model.dto.DistrictDTO;
import com.meli.tu_casita.repository.IDistrictRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    IDistrictRepository districtRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDistrict(DistrictDTO districtDTO) {
        Optional<District> district = districtRepository.findByName(districtDTO.getName());
        if (district.isEmpty()) {
            district = Optional.of(modelMapper.map(districtDTO, District.class));
            districtRepository.save(district.get());
        } else {
            throw new DistrictAlreadyExistsException(districtDTO.getName());
        }
    }

    @Override
    public List<DistrictDTO> getDistrictList() {
        List<District> districts = districtRepository.getDistrictList();
        Type listType = new TypeToken<List<DistrictDTO>>() {
        }.getType();
        return modelMapper.map(districts, listType);
    }

}

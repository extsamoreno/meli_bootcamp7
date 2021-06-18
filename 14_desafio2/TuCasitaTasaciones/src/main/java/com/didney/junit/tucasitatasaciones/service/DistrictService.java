package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;
import com.didney.junit.tucasitatasaciones.mapper.DistrictMapper;
import com.didney.junit.tucasitatasaciones.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService implements IDistrictService {
    DistrictRepository districtRepository;
    DistrictMapper districtMapper;

    public DistrictService(DistrictRepository districtRepository,
                           DistrictMapper districtMapper) {
        this.districtRepository = districtRepository;
        this.districtMapper = districtMapper;
    }

    @Override
    public DistrictDTO addDistrict(DistrictDTO districtDTO) {
        return districtMapper.districtToDistrictDTO(districtRepository.addDistrict(districtMapper.districtDTOToDistrict(districtDTO)));
    }

    @Override
    public List<DistrictDTO> addDistricts(List<DistrictDTO> districtDTOList) {
        List<DistrictDTO> response = new ArrayList<>();
        for (DistrictDTO obj : districtDTOList) {
            response.add(addDistrict(obj));
        }
        return response;
    }
}

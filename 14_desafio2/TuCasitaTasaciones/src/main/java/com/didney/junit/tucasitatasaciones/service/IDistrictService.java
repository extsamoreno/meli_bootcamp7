package com.didney.junit.tucasitatasaciones.service;

import com.didney.junit.tucasitatasaciones.dto.DistrictDTO;

import java.util.List;

public interface IDistrictService {
    DistrictDTO addDistrict(DistrictDTO districtDTO);

    List<DistrictDTO> addDistricts(List<DistrictDTO> districtDTOList);
}

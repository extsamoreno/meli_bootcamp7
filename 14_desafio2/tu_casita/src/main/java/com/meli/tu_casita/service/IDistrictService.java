package com.meli.tu_casita.service;

import com.meli.tu_casita.model.dto.DistrictDTO;

import java.util.List;

public interface IDistrictService {

    void saveDistrict(DistrictDTO districtDTO);

    List<DistrictDTO> getDistrictList();

}

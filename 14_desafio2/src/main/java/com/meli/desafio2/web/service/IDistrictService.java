package com.meli.desafio2.web.service;

import com.meli.desafio2.web.dto.DistrictDTO;

public interface IDistrictService {
    DistrictDTO getDistrictByName(String name);
}

package com.desafiotesting.api.repository;

import com.desafiotesting.api.dto.PropertyDTO;
import com.desafiotesting.api.model.District;

import java.util.Map;

public interface IDistrictsRepository {

    Map<String, District> getDistricts();
}

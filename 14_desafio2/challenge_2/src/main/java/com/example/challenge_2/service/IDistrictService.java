package com.example.challenge_2.service;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.District;

public interface IDistrictService {
    District getDistrictByName(String name) throws DistrictNotFoundException;
}

package com.example.challenge_2.repository;

import com.example.challenge_2.exception.DistrictNotFoundException;
import com.example.challenge_2.models.District;

public interface IDistrictRepository {
    District getByName(String name) throws DistrictNotFoundException;
}

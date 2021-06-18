package com.TuCasitaTasacionesAPI.TuCasita.repositories;

import com.TuCasitaTasacionesAPI.TuCasita.models.District;

public interface IDistrictRepository {
    int create(District district);
    District getById(int id);
    boolean checkDistrictExists(District district);
    boolean delete(int id);
}

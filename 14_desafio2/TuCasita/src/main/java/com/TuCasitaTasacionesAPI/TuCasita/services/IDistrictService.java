package com.TuCasitaTasacionesAPI.TuCasita.services;

import com.TuCasitaTasacionesAPI.TuCasita.dtos.DistrictDTO;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictAlreadyExistsException;
import com.TuCasitaTasacionesAPI.TuCasita.exceptions.district.DistrictNotFoundException;

public interface IDistrictService {
    int create(DistrictDTO district) throws DistrictAlreadyExistsException;
    DistrictDTO getById(int id) throws DistrictNotFoundException;
}
